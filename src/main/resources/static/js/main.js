Vue.component('insurance-form', {
    props: ['insurance'],
    data: function() {
        return {
            name: ''
        }
    },
    template:
        '<div>' +
            '<input type="text" placeholder="Name" v-model="name"/>' +
            '<input type="button" value="Save" @click="save" />' +
        '</div>',
    methods: {
        save: function() {
             var insurance = { name: this.name };
             axios.post('api', insurance).then((result) => {
                 this.insurances.push(result.data);
                 this.name = ''
             });
        }
    }
});

Vue.component('insurance-row', {
    props: ['insurance'],
    template: '<div>' +
        '<i> ({{ insurance.id }})</i>  {{ insurance.name }} ' +
        '<span>' +
            '<input type="button" value="Edit" @click="edit" />' +
            '<input type="button" value="X" @click="del" />' +
        '</span>' +
        '</div>',
    methods: {
        edit: function() {

        },
        del: function() {

        }
    }
});

Vue.component('insurances-list', {
    props: ['insurances'],
    template: '<div>' +
        '<insurance-form :insurances="insurances" />' +
        '<insurance-row v-for = "insurance in insurances" :key = "insurance.id" :insurance = "insurance"/>' +
        '</div>',
    created: function () {
        axios.get('api').then(response => {
                response.data.forEach(insurance => this.insurances.push(insurance));
        })
    }
});

var app = new Vue({
    el: '#app',
    template: '<insurances-list :insurances="insurances" />',
    data: {
        insurances: []
    }
});
