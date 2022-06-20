Vue.component('message-form', {


    template:
        '<div>' +
        '<h2>Enter your telephone number (11 - 13 digits): </h2>'+
        '<span className="enterCountryDiv">'+
        '+'+
        '<input id="enterCountryNo" aria-label="Enter phone code" cols="20" name="enterCountryNo"'+
        'pattern="[0-9]{11,13}" placeholder="Enter phone code"'+
        'required'+
        'type="tel"'+
        'style="width: 175px; font-size: large; text-align: right">'+
        '<span className="validity"></span>'+
        '</span>'+
        '<br>'+'<br>'+
        '<input type="submit" value="Check country">'+'<br>'+'<br>'+
        '<input type="button" value="Exit" @click="exit" />'+
        '</div>',});



var app = new Vue({
    el: '#app',
    template: '<message-form />',
    data: {
        message: 'Hello user'
    }
});


