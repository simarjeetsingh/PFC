<template>
    <div class="list">
        <q-breadcrumbs
                separator="/"
                active-color="primary"
                class="q-my-md q-ml-sm"
        >
            <q-breadcrumbs-el label="Inicio" to="/" />
            <q-breadcrumbs-el label="Foros" to="/foros" />
            <q-breadcrumbs-el :label="topic.title"/>
        </q-breadcrumbs>
        <h5 class="q-my-lg q-ml-md">{{topic.title}}</h5>
        <q-list no-border>
            <q-item multiline>
                <q-item-side icon="folder" inverted/>
                <q-item-main>
                    <q-item-tile label lines="5">
                        {{topic.content}}
                    </q-item-tile>
                </q-item-main>
                <q-item-side right>
                    <q-item-tile stamp>2 years</q-item-tile>
                    <q-item-tile icon="mail" color="primary"/>
                </q-item-side>
            </q-item>
            <q-item-separator class="q-ml-lg q-my-md"/>
        </q-list>
        <div v-for="(answer, key) in topic.answers" :key="key">
            <q-item multiline>
                <q-item-side icon="folder" inverted/>
                <q-item-main>
                    <q-item-tile label lines="1">
                        {{answer.content}}
                    </q-item-tile>
                    <q-item-tile sublabel lines="2">
                        {{answer.code}}
                    </q-item-tile>
                </q-item-main>
                <q-item-side right>
                    <q-item-tile stamp>2 years</q-item-tile>
                    <q-item-tile icon="mail" color="primary"/>
                </q-item-side>
            </q-item>
            <q-item-separator class="q-ml-md q-my-md"/>
        </div>
        <br/><br/>
        <div>
            <form @submit.prevent="submitAnswer">
                <q-input float-label="Contenido" class="q-my-md q-ml-md" type="textarea" v-model="model.content"/>
                <q-input float-label="Código" class="q-my-md q-ml-md" type="textarea" v-model="model.code"/>
                <!--<textarea float-label="Código" class="q-my-md" cols="50" rows="7" v-model="model.code"/>-->
                <!--<q-editor class="q-my-md" v-model="model.code"/>-->
                <q-btn size="md" class="q-my-md q-ml-md" label="Enviar" color="primary" type="submit"/>
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

    @Component({name: 'topic'})
    export default class Topic extends Vue {
        @Prop() id: string;

        $q: Quasar;
        topic = {};
        model = {content: '', code: ''};

        mounted() {
            this.getTopic();
        }

        getTopic() {
            axios
                .get('http://localhost:8080/api/topic/' + this.id,)
                .then(response => {
                    console.log(response);
                    this.topic = response.data
                })
                .catch(error => {
                })
        }

        submitAnswer() {
            axios
                .post('http://localhost:8080/api/topic/' + this.id + '/addAnswer',
                    {content: this.model.content, code: this.model.code})
                .then(response => {
                    if (response.status === 200) {
                        this.$q.notify({
                            type: 'positive',
                            message: 'Se ha añadido con éxito'
                        });
                        this.getTopic();
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
