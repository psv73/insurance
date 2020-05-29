var urn = 'api/';

function getIndex(list, id) {
    for ( var i = 0; i < list.length; i++ ) {
        if (list[i].id === id) {
            return i;
        }
    }
    return -1;
}

Vue.component('insurance-form', {
    props: ['insurance', 'insuranceAttr', 'insurances'],
    data: function() {
        return {
            name: '',
            id: ''
        }
    },
    watch: {
        insuranceAttr: function(newInsurance, oldInsurance) {
            this.name = newInsurance.name;
            this.id = newInsurance.id;
        }
    },
    template:
        '<div>' +
            '<input type="text" placeholder="Name" v-model="name" />' +
            '<input type="button" value="Save" @click="save" />' +
        '</div>',
    methods: {
        save: function() {
             var insurance = { name: this.name };

             if (this.id) {
                axios.put(urn + this.id, insurance).then(result => {
                    var index = getIndex(this.insurances, result.data.id);
                    this.insurances.splice(index, 1, result.data);
                    this.name='';
                    this.id='';
                });
             } else {
                axios.post(urn, insurance).then((result) => {
                    this.insurances.push(result.data);
                    this.name = ''
                })
             }
        }
    }
});

Vue.component('insurance-row', {
    props: ['insurance', 'editInsurance', 'insurances'],
    template:
        '<div>' +
            '<i> ({{ insurance.id }})</i>  {{ insurance.name }} ' +
            '<span style="position: absolute; right: 0;">' +
                '<input type="button" value="Edit" @click="edit" />' +
                '<input type="button" value="Delete" @click="del" />' +
            '</span>' +
        '</div>',
    methods: {
        edit: function() {
            this.editInsurance(this.insurance);
        },
        del: function() {
            axios.delete(urn + this.insurance.id).then( result => {
                if (result.status === 200) {
                    this.insurances.splice(this.insurances.indexOf(this.insurance), 1);
                }
            })
        }
    }
});

Vue.component('insurances-list', {
    props: ['insurances'],
    data: function() {
        return {
            insurance: null
        }
    },
    template:
        '<div style="position: relative; width: 300px;">' +
            '<insurance-form :insurances="insurances" :insuranceAttr="insurance"/>' +
            '<insurance-row v-for = "insurance in insurances" :key = "insurance.id" :insurance = "insurance" ' +
            ':editInsurance="editInsurance" :insurances="insurances"/>' +
        '</div>',
    created: function () {
        axios.get(urn).then(response => {
                response.data.forEach(insurance => this.insurances.push(insurance));
        })
    },
    methods: {
        editInsurance: function(insurance) {
            this.insurance = insurance;
        }
    }
});

var app = new Vue({
    el: '#app',
    template: '<insurances-list :insurances="insurances" />',
    data: {
        insurances: []
    }
});
