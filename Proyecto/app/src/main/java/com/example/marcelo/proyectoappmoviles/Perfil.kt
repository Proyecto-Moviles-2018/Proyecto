package com.example.marcelo.proyectoappmoviles

import android.os.Parcel
import android.os.Parcelable

class Perfil(var id: Int,
             var alias: String,
             var foto: String,
             var createdPerfil: Long,
             var updatedPerfil: Long): Parcelable {

    constructor(parcel: Parcel) : this(
            parcel.readInt(),
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
        destino?.writeString(alias)
        destino?.writeString(foto)
        destino?.writeLong(createdPerfil)
        destino?.writeLong(updatedPerfil)
    }

    companion object CREATOR : Parcelable.Creator<Perfil> {
        override fun createFromParcel(parcel: Parcel): Perfil {
            return Perfil(parcel)
        }

        override fun newArray(size: Int): Array<Perfil?> {
            return arrayOfNulls(size)
        }
    }

}