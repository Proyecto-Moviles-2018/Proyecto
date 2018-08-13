/**
 * Usuario.js
 *
 * @description :: A model definition.  Represents a database table/collection/etc.
 * @docs        :: https://sailsjs.com/docs/concepts/models-and-orm/models
 */

module.exports = {

  attributes: {

    nombre:{type: "string",required:true},
    contraseña:{type: "string",required:true},
    correo:{type: "string",required:true},
    tipo:{type: "string",required:true},

    perfil:{
      collection: "Perfil",
      via: "usuario",
    },

    perfilArtista:{
      collection:"PerfilArtista",
      via:"usuario"
    }

  },

};

