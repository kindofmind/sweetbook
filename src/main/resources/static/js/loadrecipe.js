var recApi = Vue.resource('/recipe');
var catApi = Vue.resource('/category{/name}');
var ingApi = Vue.resource('/ingredient{/name}');


var loadrecipe = new Vue({
  el: '#loadrecipe',
  data: {
        recipes []
        },

  created: function() {
        recipeApi.get().then(result =>
        result.json().then(data =>
        data.forEach(recipe => this.recipes.push(recipe))))
        },

  methods: {

           }
});