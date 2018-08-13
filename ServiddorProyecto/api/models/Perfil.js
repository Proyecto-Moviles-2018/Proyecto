/**
 * Perfil.js
 *
 * @description :: A model definition.  Represents a database table/collection/etc.
 * @docs        :: https://sailsjs.com/docs/concepts/models-and-orm/models
 */

module.exports = {

  attributes: {

    alias:{type: "string"},
    foto:{type: "string"},

    usuario:{
      model: "Usuario"
      /*unique: true,
      required: true*/,
    },

    listaReproduccion:{
      collection: "ListaReproduccion",
      via:"perfil"
    }
  },

};

