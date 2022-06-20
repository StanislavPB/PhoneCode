Vue.component('message-form', {


    template:
        '<div>' +
        '<label htmlFor="phone">Enter a phone number:</label>' +'<br>'+'<br>'+

        '<input type="tel" id="phone" name="phone" placeholder="+123456-1234567" pattern="(?(\\+)?\\d{1,6})[-\\s]+(\\d{7})" required>'+'<br>'+'<br>'+
        '<small>Format: 123-123-1234567</small>'+'<br>'+'<br>'+
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


