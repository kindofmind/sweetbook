var recApi = Vue.resource('/recipe');
var catApi = Vue.resource('/category{/name}');
var ingApi = Vue.resource('/ingredient{/name}');


var addrecipe = new Vue({
  el: '#addrecipe',
   data: {
        catKeyword: '',
        ingKeyword: '',
        ingCount: '',

        catFound: [],
        ingFound: [],

        editCat: false,
        editCatIndex: null,

        editIng: false,
        editIngIndex: null,

        labelCat: 'Добавить',
        labelIng: 'Добавить',

        userFn: 'Alexander',
        userLn: 'Petrov',

        recipeName: '',
        description: '',
        algorithm: '',
        catSelected: [],
        ingSelected: []

    },
      watch: {
            catKeyword: function (after, before) {
            this.getCatCreatedData()
            },
            ingKeyword: function (after, before) {
            this.getIngCreatedData()
            }
        },

     created: function () {
        this.getCatCreatedData = this.getCatData
        this.getIngCreatedData = this.getIngData
      },

    methods:
    {

     /*Work with Categories*/

          getCatData: function() {
           this.catFound = [];
           if (!this.editCat && this.catKeyword.length >= 3) {catApi.get({name: this.catKeyword}).then(result =>
           result.json().then(data =>
           data.forEach(catitem => this.catFound.push(catitem))))}
     },

          setCatData: function(catItemName) {
            if (!this.editCat && !(this.catSelected.some(item => item.name === catItemName)) && catItemName != '') {
            this.catSelected.push( { name : catItemName } );
            }
               else if (this.editCat && !(this.catSelected.some(item => item.name === catItemName))) {
               this.catSelected[this.editCatIndex].name = catItemName;
            }
               this.editCat = false;
               this.labelCat = 'Добавить';
               this.catKeyword = '';
          },

          setCatEdit: function(catId) {
                this.editCat = true;
                this.editCatIndex = catId;
                this.catKeyword = this.catSelected[catId].name;
                this.labelCat = 'Обновить';
          },

          delCat: function(catId) {
            this.catSelected.splice(catId, 1);
          },

      /*Work with Ingredients (Compositions)  */

          getIngData: function() {
          this.ingFound = [];
            if (this.ingKeyword.length >= 3) {ingApi.get({name: this.ingKeyword}).then(result =>
                result.json().then(data =>
                    data.forEach(ingItem => this.ingFound.push(ingItem))))};
          },

          useIngData: function(ingItemName) {
                if (!this.ingSelected.includes(ingItemName) && ingItemName != '') {this.ingKeyword = ingItemName};
          },

          setIngData: function(ingName, ingCount) {
                if (!this.editIng && !this.ingSelected.includes(ingName) && ingName != '') {this.ingSelected.push( { ingredient : {name : ingName}, count : ingCount } )
                }
                else if (this.editIng && !this.ingSelected.includes(ingName)) {
                this.ingSelected[this.editIngIndex].ingredient.name = ingName;
                this.ingSelected[this.editIngIndex].count = ingCount;
                }
                 this.editIng = false;
                 this.labelIng = 'Добавить';
                 this.ingKeyword = '';
                 this.ingCount = '';
          },

          setIngEdit: function(ingId) {
                           this.editIng = true;
                           this.editIng = true;
                           this.editIngIndex = ingId;
                           this.ingKeyword = this.ingSelected[ingId].ingredient.name;
                           this.ingCount = this.ingSelected[ingId].count;
                           this.labelIng = 'Обновить';
                     },

            delIng: function(ingId) {
             this.ingSelected.splice(ingId, 1);
           },

           cleanForm: function() {
                      this.recipeName = '';
                      this.description = '';
                      this.algorithm = '';
                      this.catSelected = [];
                      this.ingSelected = [];
                      this.ingCount = '';
           },

          saveRecipe: function() {
                    recipe = {
                    name : this.recipeName,
                    description : this.description,
                    algorithm : this.algorithm,
                    categories : this.catSelected,
                    compositions : this.ingSelected
                    };
                    recApi.save(recipe);
                  },
     }
});