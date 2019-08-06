var recipeApi = Vue.resource('/recipe{/id}');

var renderList = new Vue({
  el: '#renderlist',
    created: function() {
       recipeApi.get().then(result =>
           result.json().then(data =>
               data.forEach(recipe => this.recipes.push(recipe))
       )
       )
     },
      data: {
  recipes: []
  }
});