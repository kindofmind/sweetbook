var recipeApi = Vue.resource('/recipe{/id}');


Vue.component('recipe-item', {
  props: ['recipe'],
  template: '<div> <i>({{ recipe.id }})</i>  {{ recipe.name }}</div>'
});


Vue.component('recipes-list', {
 props: ['recipes'],
 template: '<div> <recipe-item v-for="recipe in recipes" v-bind:key="recipe.id" :recipe="recipe" /></div>',
  created: function() {
     recipeApi.get().then(result =>
         result.json().then(data =>
             data.forEach(recipe => this.recipes.push(recipe))
         )
     )
   }
});

var renderList = new Vue({
  el: '#renderlist',
  template: '<recipes-list :recipes="recipes" />',
  data: {
  recipes: []
  }
});