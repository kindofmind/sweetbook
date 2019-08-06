var catApi = Vue.resource('/category{/name}');
var ingApi = Vue.resource('/ingredient{/name}');


var addrecipe = new Vue({
  el: '#addrecipe',
   data: {
        catkeyword: '',
        ingkeyword: '',
        catfound: [],
        ingfound: [],
        ingcount: '',
        catselected: [],
        ingselected: [],
    },
      watch: {
            catkeyword: function (after, before) {
            this.getCatCreatedData()
            },
            ingkeyword: function (after, before) {
            this.getIngCreatedData()
            }
        },

     created: function () {
        this.getCatCreatedData = this.getCatData
        this.getIngCreatedData = this.getIngData
      },

    methods: {
     getCatData: function() {
     this.catfound = [];
       if (this.catkeyword.length >= 3) {catApi.get({name: this.catkeyword}).then(result =>
           result.json().then(data =>
               data.forEach(catitem => this.catfound.push(catitem))))}
     },
     setCatData: function(catitemname) {
     if (!(this.catselected.some(item => item.name === catitemname)) && catitemname != '') {this.catselected.push( { name : catitemname } )};
       this.catkeyword = '';
          },

     //
          getIngData: function() {
          this.ingfound = [];
            if (this.ingkeyword.length >= 3) {ingApi.get({name: this.ingkeyword}).then(result =>
                result.json().then(data =>
                    data.forEach(ingitem => this.ingfound.push(ingitem))))};
          },
           useIngData: function(useingitemname) {
                     if (!this.ingselected.includes(useingitemname) && useingitemname != '') {this.ingkeyword = useingitemname
                     };
          },

          setIngData: function(ingname,ingcount) {
                if (!this.ingselected.includes(ingname) && ingname != '') {this.ingselected.push( { name : ingname, count : ingcount } )
                };
                 this.ingkeyword = '';
                 this.ingcount = '';
          },

          deleteIngData: function(ingitemname) {
                                if (this.ingselected.some(item => item.name === ingitemname) && ingitemname != '') {ingselected.delete
                                };
                     },


     }
});

