package com.example.marcelo.proyectoappmoviles

import android.os.Parcel
import android.os.Parcelable

class ListaReproduccion(var id: Int,
                        var nombreLista: String,
                        var createdLista: Long,
                        var updatedLista: Long): Parcelable {

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
        destino?.writeString(nombreLista)
        destino?.writeLong(createdLista)
        destino?.writeLong(updatedLista)
    }

    companion object CREATOR : Parcelable.Creator<ListaReproduccion> {
        override fun createFromParcel(parcel: Parcel): ListaReproduccion {
            return ListaReproduccion(parcel)
        }

        override fun newArray(size: Int): Array<ListaReproduccion?> {
            return arrayOfNulls(size)
        }
    }

}