

Vue.component('insurance-row', {
    props: ['insurance'],
    template: '<div><i> ({{ insurance.id }})</i>  {{ insurance.name }} </div>'
});

Vue.component('insurances-list', {
    props: ['insurances'],
    template: '<div>' + '' +
        '<insurance-row v-for = "insurance in insurances" :key = "insurance.id" :insurance = "insurance"/>' +
        '</div>',
    created: function () {
        axios.get('api').then(response => {
            this.insurances = response.data;
//                this.insurances.push(response);
//            response.forEach(insurance => this.insurances.push(insurance));
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
