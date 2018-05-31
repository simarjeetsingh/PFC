import {AError, AHome, ALayout, AParent} from '../../node_modules/arteco-framework-vue-v2';
import {RouteConfig} from 'vue-router';
import Index from '../components/Index.vue';


let routes: RouteConfig[] = [
    { path: '',  component: Index },
];
export default routes;