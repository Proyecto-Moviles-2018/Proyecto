package com.example.marcelo.proyectoappmoviles

import android.os.Parcel
import android.os.Parcelable

class Genero(var id: Int,
             var nombre: String,

             var createdGenero: Long,
             var updatedGenero: Long): Parcelable {

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
        destino?.writeString(nombre)
        destino?.writeLong(createdGenero)
        destino?.writeLong(updatedGenero)
    }

    companion object CREATOR : Parcelable.Creator<Genero> {
        override fun createFromParcel(parcel: Parcel): Genero {
            return Genero(parcel)
        }

        override fun newArray(size: Int): Array<Genero?> {
            return arrayOfNulls(size)
        }
    }

}