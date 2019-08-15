var recApi = Vue.resource('/recipe');
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

        editcat: false,
        editcatindex: null,

        editing: false,

        labelcat: 'Добавить',
        labeling: 'Добавить',

        userfn: 'Alexander',
        userln: 'Petrov',
        recipename: '',
        description: '',
        algorithm: '',
        catselected: [],
        ingselected: []

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
       if (!this.editcat && this.catkeyword.length >= 3) {catApi.get({name: this.catkeyword}).then(result =>
           result.json().then(data =>
               data.forEach(catitem => this.catfound.push(catitem))))}
     },
          setCatData: function(catitemname) {
            if (!this.editcat && !(this.catselected.some(item => item.name === catitemname)) && catitemname != '') {
            this.catselected.push( { name : catitemname } );
            }
            else if (this.editcat) {
            this.catselected[this.editcatindex].name = catitemname;
            }
               this.editcat = false;
               this.labelcat = 'Добавить';
               this.catkeyword = '';
          },

          setCatEdit: function(catid) {
                this.editcat = true;
                this.editcatindex = catid;
                this.catkeyword = this.catselected[catid].name;
                this.labelcat = 'Обновить';
          },

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
                if (!this.editing && !this.ingselected.includes(ingname) && ingname != '') {this.ingselected.push( { ingredient : {name : ingname}, count : ingcount } )
                };
                if (this.editing) {
                this.ingselected
                }
                 this.ingkeyword = '';
                 this.ingcount = '';
          },

          deleteIngData: function(ingitemname) {
                                if (this.ingselected.some(item => item.name === ingitemname) && ingitemname != '') {ingselected.delete
                                };
                     },

          saveRecipe: function() {
                    recipe = {
                    name : this.recipename,
                    description : this.description,
                    algorithm : this.algorithm,
                    categories : this.catselected,
                    compositions : this.ingselected
                    };
                    recApi.save(recipe);
                     },

     }
});