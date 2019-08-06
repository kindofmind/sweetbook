var recipeApi = Vue.resource('/ingredient{/name}');

var findingredients = new Vue({
  el: '#findingredients',
   data: {
        keyword: '',
        found: [],
        selected: [name, value],
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
      useData: function(itemname) {
                if (!this.selected.includes(itemname) && itemname != '') {this.keyword = itemname
                };
     },

     setData: function(itemname, count) {
           if (!this.selected.includes(itemname) && itemname != '') {this.selected.push(itemname, count)
           };
            this.keyword = ''
     }
     }
});

