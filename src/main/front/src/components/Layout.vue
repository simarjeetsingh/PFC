<template>
    <q-layout color="primary">
        <!-- Header -->
        <q-layout-header class="site-header">
            <div class="wrap" style="width: 1140px;">
                <div class="title-area">
                    <p class="site-title">
                        <a href="#">
                            <span class="brackets">{Fp} Informática</span>
                        </a>
                    </p>
                </div>
                <div class="widget-area header-widget-area">
                    <section id="nav_menu-3" class="widget widget_nav_menu">
                        <div class="widget-wrap">
                            <nav class="nav-header">
                                <ul id="menu-main-menu" class="menu genesis-nav-menu responsive-menu">
                                    <li id="menu-item-382"
                                        class="menu-item">
                                        <a href="#">
                                            <span>¿Qué es la FP?</span>
                                        </a>
                                        <ul class="sub-menu">
                                            <li class="menu-item "><a href="" itemprop="url"><span
                                                    itemprop="name">Cómo acceder</span></a></li>
                                        </ul>
                                    </li>
                                    <li id="menu-item-341" class="menu-item">
                                        <a href="#">
                                            <span>¿Qué estudiar?</span>
                                        </a>
                                        <ul class="sub-menu">
                                            <li class="menu-item ">
                                                <a href="" itemprop="url">
                                                    <span itemprop="name">Why ?</span>
                                                </a>
                                            </li>
                                        </ul>
                                    </li>
                                    <li class="menu-item">
                                        <a href="#">
                                            <span>La profesión?</span>
                                        </a>
                                    </li>
                                    <li  class="menu-item">
                                        <a href="/">
                                            <span>Foros</span></a>
                                    </li>
                                </ul>
                            </nav>
                        </div>
                    </section>
                    <section id="text-17" class="widget widget_text">
                        <div class="widget-wrap">
                            <div class="textwidget">
                                <a href="#"><q-icon name="person" color="white" size="20px" style="margin-bottom: 4px;"/> Login</a>
                            </div>
                        </div>
                    </section>
                </div>
            </div>
        </q-layout-header>

        <!-- sub-routes get injected here: -->
        <q-page-container>
            <router-view/>
        </q-page-container>
    </q-layout>
</template>
<style>
    h1, h2, h3, h4, h5, h6, .site-header, p {
        font-family: "Roboto", sans-serif;
        /*text-transform: inherit;*/
        /*color: inherit;*/
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

    .genesis-nav-menu {
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

    .genesis-nav-menu .menu-item {
        display: inline-block;
        text-align: left;
    }

    .genesis-nav-menu a {
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

    .genesis-nav-menu .menu-item:hover {
        background-color: #444;
    }

    .genesis-nav-menu .menu-item:hover .sub-menu {
        /*display: block;*/
        opacity: 1;
        visibility: visible;
        /*transition-delay: 0.1s;*/
    }

    .genesis-nav-menu .sub-menu {
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
        color: white;
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
        color: white;
        background-color: transparent;
        text-decoration: none;
    }

    /*#text-17.widget .textwidget a::before {*/
        /*content: "\f007";*/
        /*font-family: fontawesome;*/
        /*margin-right: 10px;*/
        /*color: #fff;*/
    /*}*/

</style>
<script lang="ts">
    import Vue from 'vue';
    import Component from 'vue-class-component';

    @Component({
        name: 'layout',
    })
    export default class Layout extends Vue {

    }
</script>
