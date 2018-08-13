package com.example.marcelo.proyectoappmoviles

import android.os.Parcel
import android.os.Parcelable

class Album(var id: Int,
            var nombre: String,
            var numeroCanciones: Int,
            var caratula: String,
            var publicacion: String,
            var discografica: String,
            var createdAlbum: Long,
            var updatedAlbum: Long): Parcelable {

    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readLong(),
            parcel.readLong()) {
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(destino: Parcel?, p1: Int) {
        destino?.writeInt(id)
        destino?.writeString(nombre)
        destino?.writeInt(numeroCanciones)
        destino?.writeString(caratula)
        destino?.writeString(publicacion)
        destino?.writeString(discografica)
        destino?.writeLong(createdAlbum)
        destino?.writeLong(updatedAlbum)
    }

    companion object CREATOR : Parcelable.Creator<Album> {
        override fun createFromParcel(parcel: Parcel): Album {
            return Album(parcel)
        }

        override fun newArray(size: Int): Array<Album?> {
            return arrayOfNulls(size)
        }
    }

}