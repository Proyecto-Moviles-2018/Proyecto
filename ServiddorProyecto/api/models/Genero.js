/**
 * Genero.js
 *
 * @description :: A model definition.  Represents a database table/collection/etc.
 * @docs        :: https://sailsjs.com/docs/concepts/models-and-orm/models
 */

module.exports = {

  attributes: {

    nombre:{type: "string",required:true},

    album:{
      collection:"Album",
      via:"genero"
    },

    cancion:{
      collection:"Canciones",
      via:"genero"
    },

    artista:{
      collection:"Artista",
      via:"genero"
    }

  },

};

