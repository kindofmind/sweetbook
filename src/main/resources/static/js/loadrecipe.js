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
  this.recipes = [];
  this.currentPage = pageNumber;
  recApi.get({cmd: 'page', page: pageNumber }).then(result =>
  result.json().then(data =>
  data.forEach(recipe => {
  this.recipes.push(recipe);
  })));
 },

 nextPage: function() {
  if (this.currentPage < this.pageCount-1) this.getPageOfRecipes(this.currentPage+1);
},


 previousPage: function() {
  if (this.currentPage > 0) this.getPageOfRecipes(this.currentPage-1);
},

 isPageButtonActive: function(pageNumber) {
 if (pageNumber == this.currentPage) return 'page-item active'; else return 'page-item';
    },

 isNextButtonEnabled: function() {
 if (this.currentPage+1 < this.pageCount) return 'page-item enabled'; else return 'page-item disabled';
 },

 isPreviousButtonEnabled: function() {
  if (this.currentPage > 0) return 'page-item enabled'; else return 'page-item disabled';
  },


}

});