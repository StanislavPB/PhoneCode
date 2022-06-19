Vue.component('message-form', {

    data: function() {
        return {
            text: ''
        }
    },
    template:
        '<div>' +
        '<input type="text" placeholder="Write something" v-model="text" />' +
        '<input type="button" value="Save" @click="save" />' +
        '</div>',
    methods: {
        save: function() {
            var message = { text: this.text };


        }
    }
});



var app = new Vue({
    el: '#app',
    data: {
        message: 'Hello user'
    }
});


