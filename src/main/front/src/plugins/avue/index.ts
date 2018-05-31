import messages from './i18n';
import AVue, {apps, serviceFactory, Quasar} from 'arteco-framework-vue';
import App from 'src/App.vue';
// import {PublicApi, CategoryApi} from "../../../client";
import router from '../../router';

declare let __API_BASE_PATH: string;

// Initialize default service factory for application
const basePath = `${__API_BASE_PATH}`;

export default ({app, router, Vue}) => {

    let apiConfig = apps.ApiConfig.builder()
        .apiCallSuccessHandler((response) => response.responseJSON)
        .apiCallFailureHandler((response) => response.responseJSON)
        .build();

    // let appDef = apps.builder()
        // .name('FpInformatica')
        // .group('FpInformatica')
        // .module(new apps.ModuleDef('login', false, '/login', 'settings'))
        // .home('')
        // .apiConfig(apiConfig)
        // .build();

    // let avue = new AVue({appDef, router, messages});

    // Vue.use(AVue);

    app.render = h => h(App);
    // app.store = avue.store;
    // app.i18n = avue.i18n;
    // app.avue = avue;

    serviceFactory.init(basePath);
};