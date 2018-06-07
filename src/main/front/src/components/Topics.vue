<template>
    <div>
        {{model}}
        <h3>Topics list</h3>
        <q-btn color="primary" label="go to login" @click="$router.push('/login')"/>
        <q-btn color="primary" label="go to register" @click="$router.push('/register')"/>
    </div>
</template>
<style>
</style>
<script lang="ts">
    import Vue from 'vue';
    import Component from 'vue-class-component';
    import {Prop} from 'vue-property-decorator';
    import axios from 'axios';

    @Component({
        name: 'topics',
    })
    export default class Topics extends Vue {
        model = {};
        errored = false;

        @Prop() id: string;


        mounted() {
            axios
            // .get('https://api.coindesk.com/v1/bpi/currentprice.json')
                .get('http://localhost:8080/api/')
                .then(response => {
                    console.log(response);
                    this.model = response.data
                })
                .catch(error => {
                    // console.log(error);
                    this.errored = true
                })
        }

    }
</script>
