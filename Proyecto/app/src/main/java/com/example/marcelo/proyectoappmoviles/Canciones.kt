package com.example.marcelo.proyectoappmoviles

import android.os.Parcel
import android.os.Parcelable

class Canciones(var id: Int,
                var nombre: String,
                var duracion: String,
                var url: String,
                var createdCancion: Long,
                var updatedCancion: Long): Parcelable {

    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readLong(),
            parcel.readLong())

    {
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(destino: Parcel?, p1: Int) {
        destino?.writeInt(id)
        destino?.writeString(nombre)
        destino?.writeString(duracion)
        destino?.writeString(url)
        destino?.writeLong(createdCancion)
        destino?.writeLong(updatedCancion)
    }

    companion object CREATOR : Parcelable.Creator<Canciones> {
        override fun createFromParcel(parcel: Parcel): Canciones {
            return Canciones(parcel)
        }

        override fun newArray(size: Int): Array<Canciones?> {
            return arrayOfNulls(size)
        }
    }

}