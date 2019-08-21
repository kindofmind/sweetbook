var recApi = Vue.resource('/recipe{/cmd}{/page}');


var loadrecipe = new Vue({
  el: '#loadrecipe',
  data: {
        recipes: [],
        pageCount: null,
        currentPage: null
        },

  created: function() {
        recApi.get({cmd: 'page', page: 0}).then(result =>
        result.json().then(data =>
        data.forEach(recipe => this.recipes.push(recipe))));

        pageCount = recApi.get({cmd: 'pagecount'}).then(result => result.json().then(
        data => this.pageCount = data));
        },

  methods: {

  getPageOfRecipes: function(pageNumber) {
  this.recipes = [];
  recApi.get({cmd: 'page', page: pageNumber-1 }).then(result =>
  result.json().then(data =>
  data.forEach(recipe => this.recipes.push(recipe))));
 },

   }

});