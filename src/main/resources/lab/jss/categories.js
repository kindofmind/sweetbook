var recipeApi = Vue.resource('/category{/name}');

var findcategories = new Vue({
  el: '#findcategories',
   data: {
        keyword: '',
        found: [],
        selected: [],
    },
      watch: {
            keyword: function (after, before) {
            this.getCreatedData()
            }
        },

     created: function () {
        this.getCreatedData = this.getData
      },

    methods: {
     getData: function() {
     this.found = [];
       if (this.keyword.length >= 3) {recipeApi.get({name: this.keyword}).then(result =>
           result.json().then(data =>
               data.forEach(item => this.found.push(item))))}
     },
     setData: function(itemname) {
           if (!this.selected.includes(itemname) && itemname != '') {this.selected.push(itemname)};
            this.keyword = ''
     }
     }
});