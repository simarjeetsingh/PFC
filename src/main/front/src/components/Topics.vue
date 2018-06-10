<template>
    <div class="list">
        <q-breadcrumbs
                separator="/"
                active-color="primary"
                class="q-my-md q-ml-sm"
        >
            <q-breadcrumbs-el label="Inicio" to="/" />
            <q-breadcrumbs-el label="Foros" to="/foros" />
        </q-breadcrumbs>
        <q-btn label="Nuevo tema" color="primary" size="md" class="q-my-md q-ml-md"/>
        <q-item-separator class="q-ml-md q-my-sm"/>
        <q-list v-for="(topic, key) in topicsList" :key="key" no-border >
            <q-item multiline>
                <q-item-side icon="folder" inverted/>
                <q-item-main>
                    <q-item-tile label lines="1">
                        <a style="cursor: pointer" @click="$router.push('topic/' + topic.id)">{{topic.title}}</a>
                    </q-item-tile>
                    <q-item-tile sublabel lines="2">
                        {{topic.createdDate + ' - ' + topic.user}}
                    </q-item-tile>
                </q-item-main>
                <q-item-side right>
                    <q-item-tile stamp>2 years</q-item-tile>
                    <q-item-tile icon="mail" color="primary"/>
                </q-item-side>
            </q-item>
            <q-item-separator class="q-ml-md q-my-md"/>
        </q-list>
        <div>
            <form @submit.prevent="submitTopic" class="q-ml-md">
                <q-input class="q-my-md" float-label="Título" v-model="model.title"/>
                <q-input class="a-input q-my-md" float-label="Categoria" v-model="model.category"/>
                <q-editor class="q-my-md" v-model="model.content"/>
                <q-btn size="md" label="enviar" color="primary" type="submit" style="float: right"/>
            </form>
        </div>
    </div>
</template>
<style>
    .list {
        max-width: 1140px;
        margin-left: 105px;
    }
</style>
<script lang="ts">
    import Vue from 'vue';
    import Component from 'vue-class-component';
    import {Prop} from 'vue-property-decorator';
    import axios from 'axios';
    import Quasar from "arteco-framework-vue-v2/dist/src/definitions/quasar";

    @Component({
        name: 'topics',
    })
    export default class Topics extends Vue {
        $q: Quasar;
        topicsList = [];
        model = {title: '', content: '', category: ''};
        @Prop() id: string;

        mounted() {
            axios
            // .get('https://api.coindesk.com/v1/bpi/currentprice.json')
                .get('http://localhost:8080/api/topics')
                .then(response => {
                    console.log(response);
                    this.topicsList = response.data
                })
                .catch(error => {
                })
        }

        submitTopic() {
            axios
                .post('http://localhost:8080/api/newTopic',
                    {title: this.model.title, content: this.model.content, category: this.model.category})
                .then(response => {
                    if (response.status === 200) {
                        this.$q.notify({
                            type: 'positive',
                            message: 'Se ha añadido con éxito'
                        })
                    } else {
                        this.$q.notify({
                            type: 'negative',
                            message: 'algo ha ido mal'
                        })
                    }
                    console.log(response);
                })
                .catch(error => {
                    console.log(error);
                })

        }

    }
</script>
