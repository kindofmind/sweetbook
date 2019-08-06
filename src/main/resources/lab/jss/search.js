var recipeApi = Vue.resource('/category{/name}');

var renderList = new Vue({
  el: '#search',
   data: {
        keyword: '',
        categories: [],
        selected: [],
        toadd: ''
    },
      watch: {
            keyword: function (after, before) {
            this.getCategory()
            }
        },

     created: function () {

        this.getCategory = this.getCat
      },

    methods: {
     getCat: function() {
     this.categories = [];
       if (this.keyword.length >= 2) {recipeApi.get({name: this.keyword}).then(result =>
           result.json().then(data =>
               data.forEach(category => this.categories.push(category))))}
     },
     select: function() {
            this.selected.push(toadd)
     }


     }
});