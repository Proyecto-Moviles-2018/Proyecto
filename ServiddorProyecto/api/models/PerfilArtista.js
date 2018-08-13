/**
 * PerfilArtista.js
 *
 * @description :: A model definition.  Represents a database table/collection/etc.
 * @docs        :: https://sailsjs.com/docs/concepts/models-and-orm/models
 */

module.exports = {

  attributes: {

    alias:{type: "string",required:true},

    artista:{
      model:"Artista"
      /*unique:true,
      required:true*/
    },

    usuario:{
      model:"Usuario"
      /*unique:true,
      required:true*/
    }

  },

};

