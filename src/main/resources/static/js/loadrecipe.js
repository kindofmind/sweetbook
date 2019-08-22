var recApi = Vue.resource('/recipe{/cmd}{/page}');


var loadrecipe = new Vue({
  el: '#loadrecipe',
  data: {
        recipes: [],
        pageCount: null,
        currentPage: null
        },

  created: function() {
        this.currentPage = 0;
        recApi.get({cmd: 'page', page: this.currentPage}).then(result =>
        result.json().then(data =>
        data.forEach(recipe => this.recipes.push(recipe))));

        pageCount = recApi.get({cmd: 'pagecount'}).then(result => result.json().then(
        data => this.pageCount = data));
        },

  methods: {

  getPageOfRecipes: function(pageNumber) {
  this.currentPage = pageNumber-1;
  this.recipes = [];
  recApi.get({cmd: 'page', page: pageNumber-1 }).then(result =>
  result.json().then(data =>
  data.forEach(recipe => this.recipes.push(recipe))));
 },

 nextPage: function() {
 if (this.currentPage < this.pageCount)
 }



 isPageActive: function(pageNumber) {
 if (pageNumber == this.currentPage+1) return 'page-item active'; else return 'page-item';
    },
}

});