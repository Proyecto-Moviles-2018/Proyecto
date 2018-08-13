/**
 * Artista.js
 *
 * @description :: A model definition.  Represents a database table/collection/etc.
 * @docs        :: https://sailsjs.com/docs/concepts/models-and-orm/models
 */

module.exports = {

  attributes: {

    nombre:{type: "string",required:true},
    fechaFormacion:{type: "string"},
    integrantes:{type: "string"},
    origen:{type: "string"},
    numeroDiscos:{type: "number"},
    companiaDiscografica:{type: "number"},

    genero:{
      collection:"Genero",
      via:"artista"
    },

    album:{
      collection:"Album",
      via:"artista"
    },

    perfil:{
      collection:"PerfilArtista",
      via:"artista"
    }

  },

};

