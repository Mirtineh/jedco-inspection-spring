(this["webpackJsonp@coreui/coreui-free-react-admin-template"]=this["webpackJsonp@coreui/coreui-free-react-admin-template"]||[]).push([[9],{565:function(e,t,s){"use strict";s.d(t,"a",(function(){return c}));s(0);const c=()=>({cm_url:"/JedcoInspection/rest",um_url:"/JedcoInspection/rest",file_url:"/JedcoInspection/rest"})},618:function(e,t,s){"use strict";s.d(t,"a",(function(){return r})),s.d(t,"c",(function(){return i})),s.d(t,"b",(function(){return l}));var c=s(565),n=s(576),a=s.n(n);function r(e,t){const s=Object(c.a)().um_url;return a()({method:"post",url:s+"/auth/login",data:{username:e,password:t}}).then((e=>e.data))}function i(e){const t=Object(c.a)().um_url,s={headers:{Authorization:"Bearer ".concat(e)}};return a.a.get(t+"/statuses/getAllStatuses",s).then((e=>e.data))}function l(e,t){const s=Object(c.a)().um_url,n={headers:{Authorization:"Bearer ".concat(e)}};return a.a.get(s+"/assessment/listAssessmentsByInspection?inspectionId="+t,n).then((e=>e.data))}},868:function(e,t,s){"use strict";s.r(t);var c=s(0),n=s(137),a=s(558),r=s(559),i=s(618),l=s(89),o=s(18),d=s(138),j=s(11);t.default=()=>{const[e,t]=Object(c.useState)(""),[s,u]=Object(c.useState)(""),[b,h]=Object(c.useState)(!1),[m,x]=Object(c.useState)(!1),O=Object(o.g)(),p=e=>{var s=e.target.name,c=e.target.value;"username"==s&&(t(c),h(""==c)),"password"==s&&(u(c),x(""==c))},g=Object(l.b)(),f=()=>{0==e.length?h(!0):0==s.length?x(!0):Object(i.a)(e,s).then((e=>{e.status?(g.setLogin(e),O.push("/"),d.NotificationManager.success("Login Successful!","Success",3e3)):d.NotificationManager.error(e.message,"Login Failed!",3e3)})).catch((e=>{console.log(e),d.NotificationManager.error("Unable to try user login, check your connection","Login Failed!",3e3)}))};return Object(j.jsx)(j.Fragment,{children:Object(j.jsx)("div",{className:"c-app c-default-layout flex-row align-items-center",children:Object(j.jsx)(a.k,{children:Object(j.jsx)(a.O,{className:"justify-content-center",children:Object(j.jsx)(a.i,{md:"9",lg:"7",xl:"6",children:Object(j.jsxs)(a.e,{className:"mx-4",children:[Object(j.jsxs)(a.f,{className:"p-4",children:[Object(j.jsx)("h1",{children:"Login"}),Object(j.jsx)("p",{className:"text-muted",children:"Enter your username and password"}),Object(j.jsxs)(a.A,{className:"mb-3",children:[Object(j.jsx)(a.C,{children:Object(j.jsx)(a.D,{children:Object(j.jsx)(r.a,{name:"cil-user"})})}),Object(j.jsx)(a.y,{id:"username",size:"large",name:"username",invalid:b,value:e,placeholder:"Username",onChange:p,onKeyDown:e=>{"Enter"===e.key&&f()}}),Object(j.jsx)(a.E,{className:"help-block",children:"Please provide a valid username"})]}),Object(j.jsxs)(a.A,{className:"mb-3",children:[Object(j.jsx)(a.C,{children:Object(j.jsx)(a.D,{children:Object(j.jsx)(r.a,{name:"cil-lock-locked"})})}),Object(j.jsx)(a.y,{type:"password",placeholder:"Password",autoComplete:"new-password",name:"password",value:s,invalid:m,onChange:p,onKeyDown:e=>{"Enter"===e.key&&f()}}),Object(j.jsx)(a.E,{className:"help-block",children:"Please provide a valid password"})]}),Object(j.jsxs)(a.O,{children:[Object(j.jsx)(a.i,{xs:"6",className:"text-left",children:Object(j.jsx)(a.d,{color:"link",className:"px-0",children:"Forgot password?"})}),Object(j.jsx)(a.i,{xs:"6",children:Object(j.jsx)("div",{className:"d-flex justify-content-end",md:"6",children:Object(j.jsx)("button",{type:"submit",className:"btn btn-outline-success m-2 btn-md",onClick:f,children:"Login"})})})]})]}),Object(j.jsx)(a.g,{children:Object(j.jsxs)(a.O,{children:[Object(j.jsx)(a.i,{xs:"4"}),Object(j.jsxs)(a.i,{xs:"8",className:"text-right",children:["Not Registered yet?",Object(j.jsx)(n.b,{to:"/register",children:Object(j.jsx)(a.d,{color:"link",className:"px-0",style:{marginLeft:10,marginRight:10},children:" Register here"})})]})]})})]})})})})})})}}}]);
//# sourceMappingURL=9.038a5368.chunk.js.map