/**
 * Canciones.js
 *
 * @description :: A model definition.  Represents a database table/collection/etc.
 * @docs        :: https://sailsjs.com/docs/concepts/models-and-orm/models
 */

module.exports = {

  attributes: {

    nombre:{type: "string",required:true},
    duracion:{type: "string",required:true},
    url:{type: "string",required:true},

    lista:{
      collection:"ListaReproduccion",
      via: "cancion"
    },

    album:{
      model:"Album"
    },

    genero:{
      collection:"Genero",
      via:"cancion"
    }

  },

};

