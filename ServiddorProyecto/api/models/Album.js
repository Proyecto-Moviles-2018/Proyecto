/**
 * Album.js
 *
 * @description :: A model definition.  Represents a database table/collection/etc.
 * @docs        :: https://sailsjs.com/docs/concepts/models-and-orm/models
 */

module.exports = {

  attributes: {

    nombre:{type: "string",required:true},
    numeroCanciones:{type: "number"},
    caratula:{type: "string"},
    publicacion:{type: "string"},
    discografica:{type: "string"},

    canciones:{
      collection:"Canciones",
      via:"album"
    },

    genero:{
      collection:"Genero",
      via:"album"
    },

    artista:{
      model:"Artista"
    }

  },

};

