Vue.component('message-form', {


    template:
        '<div>' +

        '<div>'+
        '<h4>Enter your telephone number: </h4>'+
        '<span className="countryDiv">'+
        '"+"'+
        '<input id="countryNo" aria-label="Country code (up  to 3 digits)" cols="20" name="countryNo"'+
        'pattern="[0-9]{1,3}))" placeholder="Country code (up  to 3 digits)"'+
        'required'+
        'type="tel"'+
        'style="width: 175px;">'+
        '<span className="validity"></span>'+
        '</span>'+
        '<span className="areaDiv">'+
        '<input id="areaNo" aria-label="Area code (3 digits)" name="areaNo" pattern="[0-9]{3}))"'+
        'placeholder="Area code (3 digits)" required'+
        'type="tel"'+
        'style="width: 175px;">'+
        '<span className="validity"></span>'+
        '</span>'+

        '<span className="numberDiv">'+
        '<input id="number" aria-label="Phone part of number  (7 digits)" name="number" pattern="[0-9]{7}"'+
        'placeholder="Phone part of number (7 digits)" required'+
        'type="tel"'+
        'style="width: 175px;"'+
        '>'+
        '<span className="validity"></span>'+
        '</span>'+

        '</div>'+

        '<input type="submit" value="Save">'+'<br>'+'<br>'+
        '<input type="button" value="Exit" @click="exit" />'+
        '</div>',
});



var app = new Vue({
    el: '#app',
    template: '<message-form />',
    data: {
        message: 'Hello user'
    }
});


