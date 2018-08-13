package com.example.marcelo.proyectoappmoviles

import android.os.Parcel
import android.os.Parcelable

class Artista(var id: Int,
              var nombre: String,
              var fechaFormacion: String,
              var integrantes: String,
              var origen: String,
              var numeroDiscos: Int,
              var companiaDiscografica: Int,
              var createdArtista: Long,
              var updatedArtista: Long): Parcelable {

    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readLong(),
            parcel.readLong()) {
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(destino: Parcel?, p1: Int) {
        destino?.writeInt(id)
        destino?.writeString(nombre)
        destino?.writeString(fechaFormacion)
        destino?.writeString(integrantes)
        destino?.writeString(origen)
        destino?.writeInt(numeroDiscos)
        destino?.writeInt(companiaDiscografica)
        destino?.writeLong(createdArtista)
        destino?.writeLong(updatedArtista)
    }

    companion object CREATOR : Parcelable.Creator<Artista> {
        override fun createFromParcel(parcel: Parcel): Artista {
            return Artista(parcel)
        }

        override fun newArray(size: Int): Array<Artista?> {
            return arrayOfNulls(size)
        }
    }

}