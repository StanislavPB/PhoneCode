var codesApi = Vue.resource('/codes{/id}');

Vue.component('message-form', {
    props: ['messages', 'messageAttr'],
    data: function() {
        return {
            country: '',
            phone: ''
        }
    },
    watch: {
        messageAttr: function(newVal, oldVal) {
            this.country = newVal.country;
            this.phone=newVal.phone;
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
            var message = this.phone;

                codesApi.save({}, message).then(result =>
                    result.json().then(data => {
                        this.messages.push(data);
                        this.phone = ''
                    })
                )
            },
        exit:function () {
            window.close();
        }
        }

});

Vue.component('message-row', {
    props: ['message', 'messages'],
    template: '<div>' +
        '<i>({{ message.phone }})</i> {{ message.country }}'+
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
        '<message-row v-for="message in messages"  :key="message.phone"  :message="message" '+
        '</div>',

    created: function() {
        codesApi.get().then(result =>
            result.json().then(data =>
                data.forEach(message => this.messages.push(message))
            )
        )
    },
    methods: {
        editMethod: function(message) {
            this.message = message;
        }
    }
});

var app = new Vue({
    el: '#app',
    template: '<messages-list :messages="messages" />',
    data: {
        messages: []
    }
});
