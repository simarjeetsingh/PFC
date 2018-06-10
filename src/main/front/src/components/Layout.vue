<template>
    <q-layout color="primary">
        <!-- Header -->
        <q-layout-header class="site-header">
            <div class="wrap" style="width: 1140px;">
                <div class="title-area">
                    <p>
                        <a @click="$router.push('/')" style="cursor: pointer">
                            <span class="brackets">{Fp} Informática</span>
                        </a>
                    </p>
                </div>
                <div class="widget-area">
                    <section id="nav_menu-3">
                        <div>
                            <nav class="nav-header">
                                <ul class="menu nav-menu">
                                    <li class="menu-item">
                                        <a @click="$router.push('fp')" style="cursor: pointer">
                                            <span>¿Qué es la FP?</span>

                                        </a>
                                        <ul class="sub-menu">
                                            <li class="menu-item ">
                                                <a @click="$router.push('acceso')" style="cursor: pointer">
                                                    <span>Cómo acceder</span>
                                                </a>
                                            </li>
                                        </ul>
                                    </li>
                                    <li class="menu-item">
                                        <a @click="$router.push('ciclos')" style="cursor: pointer">
                                            <span>¿Qué estudiar?</span>
                                        </a>
                                        <ul class="sub-menu">
                                            <li class="menu-item ">
                                                <a>
                                                    <span>Why ?</span>
                                                </a>
                                            </li>
                                        </ul>
                                    </li>
                                    <li class="menu-item">
                                        <a @click="$router.push('profesion')" style="cursor: pointer">
                                            <span>La profesión</span>
                                        </a>
                                    </li>
                                    <li class="menu-item">
                                        <a @click="$router.push('foros')" style="cursor: pointer">
                                            <span>Foros</span></a>
                                    </li>
                                </ul>
                            </nav>
                        </div>
                    </section>
                    <section id="text-17" class="widget widget_text">
                        <div class="widget-wrap">
                            <nav class="nav-header">
                                <ul v-if="!showLogout" class="menu nav-menu">
                                    <li class="menu-item">
                                        <a @click="showRegisterModal" style="cursor: pointer; padding: 0 10px">
                                            <!--<q-icon name="person_add" color="white" size="20px"-->
                                            <!--style="margin-bottom: 4px;"/>-->
                                            Registro</a>
                                    </li>
                                    <li class="menu-item">
                                        <a @click="showLoginModal" style="cursor: pointer; padding: 0;">Login</a>
                                    </li>
                                </ul>
                                <ul v-else class="menu nav-menu">
                                    <li class="menu-item">
                                        <a @click="logout" style="cursor: pointer; padding: 0 10px">
                                            Logout
                                        </a>
                                    </li>
                                </ul>
                            </nav>
                        </div>
                    </section>
                </div>
            </div>
        </q-layout-header>
        <a-modal ref="loginModal" flat-actions minimized alignActions="right">
            <p style="text-align: center; font-size: 30px">Login</p>
            <form @submit.prevent="userLogin">
                <q-input float-label="Nombre de usuario" name="username" v-model="model.username"/>
                <q-input float-label="Contraseña" name="password" v-model="model.password"/>
                <!--<q-btn size="md" label="login" color="primary"  flat @click="userLogin"/>-->
                <!--<q-btn size="md" label="register" color="primary"  type="submit" flat @click="register" float="right"/>-->
                <q-btn size="md" label="login" color="primary" type="submit" flat/>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </form>
        </a-modal>

        <a-modal ref="registerModal" flat-actions  minimized alignActions="right" >
            <p style="text-align: center; font-size: 30px">Registro</p>
            <form @submit.prevent="register">
                <q-input float-label="Nombre de usuario" v-model="model.username"/>
                <q-input float-label="Contraseña" v-model="model.password"/>
                <q-input float-label="Introducción" v-model="model.introduction"/>
                <!--<q-btn size="md" label="login" color="primary"  flat @click="userLogin"/>-->
                <!--<q-btn size="md" label="register" color="primary"  type="submit" flat @click="register" float="right"/>-->
                <q-btn size="md" label="enviar" color="primary" type="submit" flat/>
            </form>
        </a-modal>

        <!-- sub-routes get injected here: -->
        <q-page-container>
            <router-view/>
        </q-page-container>
    </q-layout>
</template>
<style>
    h1, h2, h3, h4, h5, h6, .site-header, p {
        font-family: "Roboto", sans-serif;
    }

    .site-header {
        background-color: #000;
        left: 0;
        position: fixed;
        top: 0;
        width: 100%;
        z-index: 999;
    }

    .site-header .wrap {
        max-width: 1140px;
        margin-left: 105px;
    }

    .title-area {
        padding: 0;
        float: none;
        position: absolute;
        top: 0px;
        width: auto;
        line-height: 64px;
    }

    .site-header .widget-area {
        float: none;
        text-align: center;
        width: auto;
    }

    section#nav_menu-3 {
        display: inline-block;
        margin-left: 215px;
    }

    .nav-menu {
        clear: both;
        color: #fff;
        font-family: Montserrat, sans-serif;
        font-size: 16px;
        font-weight: 400;
        letter-spacing: 1px;
        line-height: 1;
        width: 100%;
    }

    ol, ul {
        margin: 0;
        padding: 0;
        color: #ffffff;
        font-family: Roboto, sans-serif;
        font-size: 16px;
    }

    .nav-menu .menu-item {
        display: inline-block;
        text-align: left;
    }

    .nav-menu a {
        padding: 0 20px;
        line-height: 70px;
        transition: background .3s;
        display: block;
    }

    section#text-17 {
        display: inline-block;
        float: right;
    }

    #text-17.widget .textwidget a {
        font-size: 16px;
        text-transform: none;
        margin-top: 15px;
        line-height: 37px;
        display: block;
        transition: color .3s;
        color: #fff;
    }

    .brackets {
        color: #699e4f;
        font-family: Roboto, sans-serif;
        font-size: 26px;
        font-style: italic;
    }

    a {
        text-decoration: none;
    }

    .nav-menu .menu-item:hover {
        background-color: #444;
    }

    .nav-menu .menu-item:hover .sub-menu {
        /*display: block;*/
        opacity: 1;
        visibility: visible;
        /*transition-delay: 0.1s;*/
    }

    .nav-menu .sub-menu {
        padding: 20px 0 10px;
        background-color: #444;
        width: 300px;
        position: absolute;
        /*display: none;*/
        visibility: hidden;
        z-index: 1;
        opacity: 0;
        /*transition: visibility 0s, opacity 0.5s linear;*/
        transition: opacity .4s ease-in-out;
    }

    a:link {
        color: #699e4f;
        background-color: transparent;
        text-decoration: none;
    }

    a:visited {
        color: white;
        background-color: transparent;
        text-decoration: none;
    }

    a:hover {
        color: #699e4f;
        background-color: transparent;
        text-decoration: none;
    }

    a:active {
        color: #699e4f;
        background-color: transparent;
        text-decoration: none;
    }
</style>
<script lang="ts">
    import Vue from 'vue';
    import Component from 'vue-class-component';
    import AModal from './AModal'
    import axios from 'axios';
    import Quasar from "arteco-framework-vue-v2/dist/src/definitions/quasar";

    @Component({
        name: 'layout',
        components: {AModal}
    })
    export default class Layout extends Vue {
        $q: Quasar;
        showLogout: boolean = false;

        model = {username: '', password: '', introduction: ''};

        // register = {username: '', password: ''};

        showLoginModal() {
            (<AModal> this.$refs.loginModal).open();
        }

        showRegisterModal() {
            (<AModal> this.$refs.registerModal).open();
        }

        userLogin() {
            console.log('login clicked');
            axios
                .get('http://localhost:8080/api/login')
                .then(response => {
                    this.showLogout = true,
                        console.log(response);
                    console.log('logged...');
                })
                .catch(error => {
                    console.log(error);
                })

        }

        register() {
            let data = JSON.stringify({
                username: this.model.username,
                password: this.model.password,
                introduction: this.model.introduction
            });


            axios
            // .post('http://localhost:8080/api/register', {username: this.model.username, password: this.model.password} )
                .post('http://localhost:8080/api/register', data, {
                    headers: {
                        'Content-Type': 'application/json',
                    }
                })
                .then(response => {
                    if (response.status === 200) {
                        this.$q.notify({
                            type: 'positive',
                            message: 'El usuario se ha registrado correctamente'
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
