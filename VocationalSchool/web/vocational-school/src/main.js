// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import 'element-ui/lib/theme-chalk/index.css';
import { Button, Select,Row,Input,Link,Menu,MenuItem,Carousel,CarouselItem,Col } from 'element-ui';
import Global from './global';

Vue.component(Button.name, Button);
Vue.component(Select.name, Select);
Vue.component(Row.name, Row);
Vue.component(Input.name, Input);
Vue.component(Link.name, Link);
Vue.component(Menu.name, Menu);
Vue.component(MenuItem.name, MenuItem);
Vue.component(Carousel.name, Carousel);
Vue.component(CarouselItem.name, CarouselItem);
Vue.component(Col.name, Col);
 
Vue.prototype.Global = Global
Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
