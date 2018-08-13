package com.example.marcelo.proyectoappmoviles

import android.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.microsoft.bing.speech.SpeechClientStatus
import com.microsoft.cognitiveservices.speechrecognition.*
import kotlinx.android.synthetic.main.activity_search.*

class SearchActivity : AppCompatActivity(), ISpeechRecognitionServerEvents {

    internal var m_waitSeconds = 0
    internal var micClient: MicrophoneRecognitionClient? = null
    internal var isReceivedResponse = FinalResponseStatus.NotReceived
    lateinit var _logText: EditText
    lateinit var _startButton: ImageButton
    var resultadoBusqueda = ""

    val primaryKey: String
        get() = this.getString(R.string.primaryKey)
    private val authenticationUri: String
        get() = this.getString(R.string.authenticationUri)

    private val mode: SpeechRecognitionMode
        get() = SpeechRecognitionMode.LongDictation

    enum class FinalResponseStatus {
        NotReceived, OK, Timeout
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)


        //this._logText = findViewById<View>(R.id.editText1) as EditText
        this._startButton = findViewById<View>(R.id.boton_stt) as ImageButton

        //val toast = Toast.makeText(this, "Start STT", Toast.LENGTH_LONG)
        //toast.show()

        if (getString(R.string.primaryKey).startsWith("Please")) {
            AlertDialog.Builder(this)
                    .setTitle(getString(R.string.add_subscription_key_tip_title))
                    .setMessage(getString(R.string.add_subscription_key_tip))
                    .setCancelable(false)
                    .show()
        }

        // setup the buttons
        val This = this
        this._startButton.setOnClickListener { arg0 -> This.StartButton_Click(arg0) }

    }

    private fun StartButton_Click(arg0: View) {
        this._startButton.isEnabled = false

        this.m_waitSeconds = if (this.mode == SpeechRecognitionMode.ShortPhrase) 20 else 200


        this.micClient = SpeechRecognitionServiceFactory.createMicrophoneClient(
                this,
                mode,
                "en-us",
                this,
                this.primaryKey)

        this.micClient!!.authenticationUri = this.authenticationUri
        this.micClient!!.startMicAndRecognition()

    }

    override fun onAudioEvent(recording: Boolean) {
        this.WriteLine("--- Microphone status change received by onAudioEvent() ---")
        this.WriteLine("********* Microphone status: $recording *********")
        if (recording) {
            //this.WriteLine("Please start speaking.");
            val toast = Toast.makeText(this, "Start Speaking", Toast.LENGTH_LONG)
            toast.show()
        }

        WriteLine()
        if (!recording) {
            this.micClient!!.endMicAndRecognition()
            this._startButton.isEnabled = true
        }
    }

    private fun WriteLine() {
        this.WriteLine("")
    }

    private fun WriteLine(text: String) {
        //this._logText.append(text + "\n")
    }

    override fun onPartialResponseReceived(response: String) {
        this.WriteLine("--- Partial result received by onPartialResponseReceived() ---")
        this.WriteLine(response)
        this.WriteLine()
    }

    override fun onFinalResponseReceived(response: RecognitionResult) {
        val isFinalDicationMessage = this.mode == SpeechRecognitionMode.LongDictation && (response.RecognitionStatus == RecognitionStatus.EndOfDictation || response.RecognitionStatus == RecognitionStatus.DictationEndSilenceTimeout)
        if (null != this.micClient && true && (this.mode == SpeechRecognitionMode.ShortPhrase || isFinalDicationMessage)) {
            // we got the final result, so it we can end the mic reco.  No need to do this
            // for dataReco, since we already called endAudio() on it as soon as we were done
            // sending all the data.
            this.micClient!!.endMicAndRecognition()
        }

        if (isFinalDicationMessage) {
            this._startButton.isEnabled = true
            this.isReceivedResponse = FinalResponseStatus.OK
        }

        if (!isFinalDicationMessage) {
            this.WriteLine("********* Final n-BEST Results *********")
            for (i in response.Results.indices) {
                this.WriteLine("[" + i + "]" + " Confidence=" + response.Results[i].Confidence +
                        " Text=\"" + response.Results[i].DisplayText + "\"")
                this.resultadoBusqueda = response.Results[i].DisplayText
                this.editText_buscar.setText(this.resultadoBusqueda)
            }

            this.WriteLine()
            this.micClient!!.endMicAndRecognition()
        }
    }

    override fun onIntentReceived(payload: String) {
        this.WriteLine("--- Intent received by onIntentReceived() ---")
        this.WriteLine(payload)
        this.WriteLine()
    }

    override fun onError(errorCode: Int, response: String) {
        this._startButton.isEnabled = true
        this.WriteLine("--- Error received by onError() ---")
        this.WriteLine("Error code: " + SpeechClientStatus.fromInt(errorCode) + " " + errorCode)
        this.WriteLine("Error text: $response")
        this.WriteLine()
    }


    /*    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }*/

}
