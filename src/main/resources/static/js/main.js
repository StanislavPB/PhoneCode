var codesApi = Vue.resource('/codes{/id}');

Vue.component('phone-form', {
    data: function (){
      return {
          phoneNumber:''
      }
    },

    template:
        '<div>' +
        '<h2>Enter your telephone number (11 - 13 digits): </h2>'+
        '<span className="enterCountryDiv">'+
        '+'+
        '<input id="enterCountryNo" aria-label="Enter phone code" cols="20" name="enterCountryNo"'+
        'pattern="[0-9]{11,13}" placeholder="Enter phone code" v-model="phoneNumber" '+
        'type ="tel"'+
        'style="width: 175px; font-size: large; text-align: right">'+
        '<span className="validity"></span>'+
        '</span>'+
        '<br>'+'<br>'+
        '<input type="button" value="Check country" @click="check">'+
        '<br>'+'<br>'+
        '<input type="button" value="Exit" @click="exit" />'+'<br>'+'<br>'+'<br>'+'<br>'+
        '<country-form :country="country"  />' +
        '</div>',
    methods:{
        check: function () {
            var phone = this.phoneNumber;
            codesApi.save({},phone)},
        exit:function () {
            window.close();
        }
    }
});


Vue.component('country-form', {
    props: ['countries'],
    data: function() {
        return {
            country: null
        }
    },
    template:
        '<div style="position: relative; width: 300px;">' +
        '<phone-form  />' +
        '{{ country.text }}' +
        '</div>',
    created: function() {
        codesApi.get().then(result =>
            result.json().then(data =>
                data.forEach(country => this.country.push(country))
            )
        )
    }
});



var app = new Vue({
    el: '#app',
    template: '<phone-form />',
    data: {
        message: 'Hello user'
    }
});


