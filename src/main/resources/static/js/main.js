Vue.component('message-form', {


    template:
        '<div>' +
        '<input type="text" placeholder="Write something" v-model="text" />' +
        '<input type="button" value="Save" @click="save" />' +
        '</div>',

});



var app = new Vue({
    el: '#app',
    data: {
        message: 'Hello user'
    }
});


