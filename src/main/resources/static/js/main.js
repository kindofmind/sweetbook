var recipeApi = Vue.resource('/recipe{/id}')

Vue.component('recipe-form', {
 props: ['recipes'],
 data: function() {
 return {
 text: ''
 }
 },
template: '<div>' +
            '<input type="text" placeholder="Write here" v-model="text" / >' +
            '<input type="button" value="Save" v-on:click="save"  / >' +
            '</div>',
           methods:  {
           save: function() {
           var recipe = {name : this.text};
           recipeApi.save({}, recipe).then(result => result.json().then(data => {
           this.recipes.push(data);
           })
            )
           }
          }
});


Vue.component('recipe-row', {
    props: ['recipe'],
    template: '<div> {{ recipe.id }} {{ recipe.name }}</div>'
});

Vue.component('recipes-list', {
  props: ['recipes'],
  template: '<div>+
 '<recipe-form :recipes="recipes" />  ' +
 '<recipe-row v-for="recipe in recipes" v-bind:key="recipe.id" :recipe="recipe" /></div>',
  created: function() {
    recipeApi.get().then(result => result.json.then(
    data.forEach(recipe => this.recipes.push())
    )
   )
  }
});

var app = new Vue({
el: "#app",
template: '<recipes-list :recipes="recipes" />  ',
data: {
    recipes: []
}
});