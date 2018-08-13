package com.example.marcelo.proyectoappmoviles

import android.os.Parcel
import android.os.Parcelable

class PerfilArtista(var id: Int,
                    var alias: String,
                    var createdPerfilArtista: Long,
                    var updatedPerfilArtista: Long): Parcelable {

    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readString(),
            parcel.readLong(),
            parcel.readLong()) {
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(destino: Parcel?, p1: Int) {
        destino?.writeInt(id)
        destino?.writeString(alias)
        destino?.writeLong(createdPerfilArtista)
        destino?.writeLong(updatedPerfilArtista)
    }

    companion object CREATOR : Parcelable.Creator<PerfilArtista> {
        override fun createFromParcel(parcel: Parcel): PerfilArtista {
            return PerfilArtista(parcel)
        }

        override fun newArray(size: Int): Array<PerfilArtista?> {
            return arrayOfNulls(size)
        }
    }

}