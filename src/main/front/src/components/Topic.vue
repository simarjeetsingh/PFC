<template>
    <div>
        <h3>I'm I'm topic</h3>
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
        name: 'topic',
    })
    export default class Topic extends Vue {

        @Prop() id: string;

    }
</script>
