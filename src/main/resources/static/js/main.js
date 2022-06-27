var codesApi = Vue.resource('/codes{/id}');

Vue.component('message-form', {
    props: ['messages'],
    data: function() {
        return {
            message: '',
            phone: ''
        }
    },

    template:
        '<div>' +
        '<h2>Enter your telephone number (11 - 13 digits): </h2>'+
        '<span className="enterCountryDiv">'+
        '+'+
        '<input id="enterCountryNo" aria-label="Enter phone code"  name="enterCountryNo" pattern="[0-9]{11,13}" placeholder="Enter phone code" v-model=phone type ="tel" style="width: 175px; font-size: large; text-align: right" />'+
        '<span className="validity"></span>'+
        '</span>'+
        '<br>'+'<br>'+
        '<input type="button" value="Detect country" @click="detect" />'+
        '<br>'+'<br>'+
        '<input type="button" value="Exit" @click="exit" />'+'<br>'+'<br>'+'<br>'+'<br>'+
        '</div>',

    methods: {
        detect: function() {
            let phone = this.phone;

                codesApi.save({},phone).then(result =>
                    result.json().then(data => {
                        this.messages.push(data);
                        this.phone = ''
                    })
                )
            },
        exit:function () {
            window.location.href = "http://localhost:8080/exit"
            window.close();
        }
        }

});

Vue.component('message-row', {
    props: ['message', 'messages'],
    template: '<div>' +
        '<div><div v-for="message in messages" {{ message}} </div></div'+
        '<span style="position: absolute; right: 0">' +

        '</span>' +
        '</div>',

});

Vue.component('messages-list', {
    props: ['messages'],
    data: function() {
        return {
            message: null
        }
    },
    template:
        '<div style="position: relative; width: 300px;">' +
        '<message-form :messages="messages" :messageAttr="message" />' +
        'Список стран:'+
        '<message-row v-for="message in messages"   :message="message" '+
        '</div>',

    created: function() {
     codesApi.get().then(result =>
         result.json().then(data=>
         console.log(data))
        )
    },
});

var app = new Vue({
    el: '#app',
    template: '<messages-list :messages="messages" />',
    data: {
        messages: []
    }
});
