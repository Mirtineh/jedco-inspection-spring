(this["webpackJsonp@coreui/coreui-free-react-admin-template"]=this["webpackJsonp@coreui/coreui-free-react-admin-template"]||[]).push([[11],{591:function(e,t,n){"use strict";n.d(t,"i",(function(){return a})),n.d(t,"g",(function(){return o})),n.d(t,"h",(function(){return i})),n.d(t,"c",(function(){return l})),n.d(t,"n",(function(){return d})),n.d(t,"m",(function(){return u})),n.d(t,"e",(function(){return b})),n.d(t,"j",(function(){return j})),n.d(t,"d",(function(){return h})),n.d(t,"a",(function(){return m})),n.d(t,"b",(function(){return O})),n.d(t,"f",(function(){return p})),n.d(t,"l",(function(){return f})),n.d(t,"k",(function(){return x}));var s=n(565),c=n(575),r=n.n(c);const a=e=>{const t=Object(s.a)().um_url,n={headers:{Authorization:"Bearer ".concat(e)}};return r.a.get(t+"/UserRole/userRoleList",n).then((e=>e.data))},o=e=>{const t=Object(s.a)().um_url,n={headers:{Authorization:"Bearer ".concat(e)}};return r.a.get(t+"/UserAction/userActionList",n).then((e=>e.data))},i=(e,t)=>{const n=Object(s.a)().um_url,c={headers:{Authorization:"Bearer ".concat(e)}};return r.a.get(n+"/roleDefinition/definedRolesList?userRoleId="+t,c).then((e=>e.data))};function l(e,t){const n=Object(s.a)().um_url;return r()({method:"post",url:n+"/roleDefinition/defineRole",headers:{Authorization:"Bearer ".concat(e)},data:t}).then((e=>e.data))}function d(e,t){const n=Object(s.a)().um_url;return r()({method:"put",url:n+"/UserRole/updateUserRole",headers:{Authorization:"Bearer ".concat(e)},data:{id:t.id,name:t.name,description:t.description}}).then((e=>e.data))}function u(e,t){const n=Object(s.a)().um_url;return r()({method:"put",url:n+"/roleDefinition/updateDefinedActions",headers:{Authorization:"Bearer ".concat(e)},data:t}).then((e=>e.data))}function b(e,t){const n=Object(s.a)().um_url;return r()({method:"delete",url:n+"/roleDefinition/deleteUserRole?UserRoleID="+t,headers:{Authorization:"Bearer ".concat(e)}}).then((e=>e.data))}const j=e=>{const t=Object(s.a)().um_url,n={headers:{Authorization:"Bearer ".concat(e)}};return r.a.get(t+"/User/userList",n).then((e=>e.data))},h=(e,t)=>{const n=Object(s.a)().um_url;return r()({method:"post",url:n+"/User/createUser",headers:{Authorization:"Bearer ".concat(e)},data:t}).then((e=>e.data))},m=e=>{const t=Object(s.a)().um_url;return r.a.get(t+"/User/activationNumCheck?activationNO="+e).then((e=>e.data))},O=e=>{const t=Object(s.a)().um_url;return r()({method:"post",url:t+"/User/setUserNameAndPassword",data:e}).then((e=>e.data))};function p(e,t){const n=Object(s.a)().um_url;return r()({method:"delete",url:n+"/User/deleteUser?userId="+t,headers:{Authorization:"Bearer ".concat(e)}}).then((e=>e.data))}function f(e,t){const n=Object(s.a)().um_url;return r()({method:"put",url:n+"/User/suspendUser?userId="+t,headers:{Authorization:"Bearer ".concat(e)}}).then((e=>e.data))}function x(e,t){const n=Object(s.a)().um_url;return r()({method:"put",url:n+"/User/reactivateUser?userId="+t,headers:{Authorization:"Bearer ".concat(e)}}).then((e=>e.data))}},876:function(e,t,n){"use strict";n.r(t);var s=n(0),c=n.n(s),r=n(558),a=n(818),o=(n(817),n(878)),i=n(591),l=n(89),d=n(138),u=n(887),b=n(875),j=n(854),h=n(874),m=n(872),O=n(11);const p=c.a.forwardRef((function(e,t){return Object(O.jsx)(m.a,{direction:"up",ref:t,...e})})),f=[{key:"name",_classes:"font-weight-bold"},{key:"description",sorter:!1,filter:!1},"createdOn",{key:"role_details",label:"Details",sorter:!1,filter:!1},{key:"updates",label:"",sorter:!1,filter:!1},{key:"deletes",label:"",sorter:!1,filter:!1}];t.default=()=>{const[e,t]=c.a.useState(!1),[n,m]=Object(s.useState)([]),[x,g]=Object(s.useState)(!1),[N,k]=Object(s.useState)(""),[U,z]=Object(s.useState)(""),[y,v]=Object(s.useState)(""),[A,w]=Object(s.useState)(""),[C,D]=Object(s.useState)(""),[R,S]=Object(s.useState)([]),[M,F]=Object(s.useState)([]),[_,B]=Object(s.useState)(0),I=Object(l.b)(),P=()=>{Object(i.i)(I.login.token).then((e=>{m(e),console.log(e)})).catch((e=>console.log(e))),Object(i.g)(I.login.token).then((e=>{S(e)})).catch((e=>console.log(e)))};Object(s.useEffect)((()=>{P()}),[]);const Y=(e,t,n)=>{g(!x),k(e),v(t),z(t),D(n),""==e&&F([])};return Object(O.jsxs)(O.Fragment,{children:[Object(O.jsx)(a.a,{}),Object(O.jsxs)(r.J,{show:x,onClose:()=>{Y("","","")},size:"lg",backdrop:!0,closeOnBackdrop:!1,children:[Object(O.jsx)(r.M,{size:"modal-lg",closeButton:!0,children:Object(O.jsxs)("h4",{children:[Object(O.jsx)("small",{children:0==N?"Create User Role":"Update User Role"})," - ",0==N?y:U]})}),Object(O.jsxs)(r.K,{children:[Object(O.jsx)("form",{onSubmit:e=>{e.preventDefault();const t={id:N,name:y,description:C};Object(i.n)(I.login.token,t).then((e=>{e.status?(d.NotificationManager.success(e.message,"Success",3e3),P(),z(y)):d.NotificationManager.error(e.message,"Update Failed!",3e3)})).catch((e=>{console.log(e),403==e.response.status?d.NotificationManager.error("You are not allowed to perform this task","Update Failed!",3e3):d.NotificationManager.error("Unable to try Role Update, check your connection","Update Failed!",3e3)}))},children:Object(O.jsxs)("div",{class:"form-row",children:[Object(O.jsx)("div",{class:"col-md-5 mb-3",children:Object(O.jsx)(o.a,{id:"outlined-basic",label:"Name",onInput:e=>v(e.target.value),value:y,size:"small",variant:"outlined",required:!0})}),Object(O.jsx)("div",{class:"col-md-5 mb-3",children:Object(O.jsx)(o.a,{id:"outlined-basic",label:"Description",multiline:!0,rows:3,onInput:e=>D(e.target.value),value:C,size:"small",variant:"outlined"})}),Object(O.jsx)("div",{class:"col-md-2 mb-3",children:0==N?"":Object(O.jsx)("button",{type:"submit",className:"btn btn-outline-success m-2 btn-md",children:"Update"})})]})}),Object(O.jsx)("hr",{}),Object(O.jsx)(r.M,{size:"modal-lg",children:Object(O.jsxs)("h4",{children:[Object(O.jsx)("small",{children:0==N?"Assign Actions for ":"Update Role Actions for "})," - ",0==N?y:U]})}),R.map(((e,t)=>Object(O.jsx)(O.Fragment,{children:Object(O.jsx)("div",{id:"accordion",children:Object(O.jsxs)(r.e,{className:"mb-0",children:[Object(O.jsx)(r.h,{id:"headingOne",children:Object(O.jsx)(r.d,{block:!0,color:"link",className:"text-left",children:Object(O.jsx)("h5",{className:"m-0 p-0",children:e.groupName})})}),Object(O.jsx)(r.j,{show:0===_,children:Object(O.jsx)(r.f,{children:Object(O.jsx)(r.e,{children:Object(O.jsx)(r.H,{children:e.actionsDtos.map((e=>{let t=!1;return M.includes(e.userActionId)&&(t=!0),Object(O.jsx)(O.Fragment,{children:Object(O.jsx)(r.I,{children:Object(O.jsxs)("div",{className:"d-flex justify-content-between",children:[e.action,Object(O.jsx)(r.Y,{className:"mx-1",color:"success",labelOn:"\u2713",labelOff:"\u2715",checked:t,onChange:()=>{(e=>{let t=M;new Promise(((n,s)=>{const c=t.indexOf(e);c>-1?t.splice(c,1):t.push(e),n()})).then((()=>{console.log("zzzzzzzzzzzzzzzzzzzz "+t),F(t)})),F([e])})(e.userActionId)}})]})})})}))})})})})]})})})))]}),Object(O.jsxs)("div",{className:"d-flex justify-content-between",children:[0==N?Object(O.jsx)("button",{type:"button",className:"btn btn-outline-danger m-2 btn-md",onClick:()=>{Y("","","")},children:"Cancel"}):Object(O.jsx)("button",{type:"button",className:"btn btn-outline-danger m-2 btn-md",onClick:()=>{Y("","","")},children:"Close"}),0==N?Object(O.jsx)("button",{className:"btn btn-outline-success m-2 btn-md",type:"submit",onClick:e=>{if(e.preventDefault(),""==y)a.b.error("Role Name Can not be empty!",{position:"top-center",autoClose:3e3,hideProgressBar:!0,closeOnClick:!0,pauseOnHover:!0,draggable:!0,progress:void 0});else{const e={userRoleName:y,userRoleDescription:C,userActions:M};Object(i.c)(I.login.token,e).then((e=>{e.status?(d.NotificationManager.success(e.message,"Success",3e3),P(),Y("","","")):d.NotificationManager.error(e.message,"Update Failed!",3e3)})).catch((e=>{console.log(e),403==e.response.status?d.NotificationManager.error("You are not allowed to perform this task","Update Failed!",3e3):d.NotificationManager.error("Unable to try Update, check your connection","Update Failed!",3e3)}))}},children:"Submit"}):Object(O.jsx)("button",{className:"btn btn-outline-success m-2 btn-md",onClick:e=>{e.preventDefault();const t={userRoleId:N,userActions:M};Object(i.m)(I.login.token,t).then((e=>{e.status?(d.NotificationManager.success(e.message,"Success",3e3),P()):d.NotificationManager.error(e.message,"Update Failed!",3e3)})).catch((e=>{console.log(e),403==e.response.status?d.NotificationManager.error("You are not allowed to perform this task","Update Failed!",3e3):d.NotificationManager.error("Unable to try Update, check your connection","Update Failed!",3e3)}))},children:"Update"})]}),Object(O.jsx)(r.L,{})]}),Object(O.jsx)(r.O,{children:Object(O.jsx)(r.i,{xl:12,children:Object(O.jsxs)(r.e,{children:[Object(O.jsx)(r.h,{children:Object(O.jsxs)("div",{className:"d-flex justify-content-between",children:[Object(O.jsxs)("div",{children:[Object(O.jsx)("h4",{style:{marginBottom:2},children:"Roles"}),Object(O.jsx)("small",{className:"text-muted",children:" user roles"})]}),Object(O.jsx)("div",{className:"d-flex justify-content-end",children:Object(O.jsx)("button",{type:"button",className:"btn btn-outline-success m-2 btn-md",onClick:()=>{Y(0,"","")},children:"Add Role"})})]})}),Object(O.jsx)(r.f,{children:Object(O.jsx)(r.m,{items:n,fields:f,hover:!0,tableFilter:!0,striped:!0,itemsPerPage:5,itemsPerPageSelect:!0,clickableRows:!0,scopedSlots:{createdOn:e=>Object(O.jsx)("td",{children:new Date(parseFloat(e.createdOn)).toLocaleString()}),role_details:(e,t)=>Object(O.jsx)("td",{className:"py-2",children:Object(O.jsx)(r.d,{color:"primary",variant:"outline",shape:"square",size:"sm",children:"Detail"})}),updates:(e,t)=>Object(O.jsx)("td",{className:"py-2",children:Object(O.jsx)(r.d,{color:"warning",variant:"outline",shape:"square",size:"sm",disabled:"Admin"==e.name,onClick:()=>{(e=>{let t=[];new Promise(((n,s)=>{Object(i.h)(I.login.token,e.id).then((e=>{e[0].userActionList.forEach((function(e){t.push(e.id),console.log(e.id)})),n()})).catch((e=>console.log(e)))})).then((()=>{console.log(" pushed "+t),F(t),Y(e.id,e.name,e.description),console.log("role actions - - -"+t)}))})(e)},children:"Update"})}),deletes:(e,n)=>Object(O.jsx)("td",{className:"py-2",children:Object(O.jsx)(r.d,{color:"danger",variant:"outline",shape:"square",disabled:"Admin"==e.name,size:"sm",onClick:()=>(e=>{t(!0),w(e)})(e),children:"Delete"})})}})})]})})}),Object(O.jsx)("div",{children:Object(O.jsxs)(u.a,{open:e,TransitionComponent:p,keepMounted:!0,"aria-labelledby":"alert-dialog-slide-title","aria-describedby":"alert-dialog-slide-description",children:[Object(O.jsx)(h.a,{id:"alert-dialog-slide-title",children:Object(O.jsx)("h5",{children:"Are You sure?"})}),Object(O.jsx)(b.a,{children:Object(O.jsx)(j.a,{id:"alert-dialog-slide-description",children:Object(O.jsxs)("div",{children:[Object(O.jsx)("h5",{style:{textAlign:"center"},children:Object(O.jsxs)("small",{children:["You are about to delete role ",Object(O.jsx)("strong",{children:A.name})]})}),Object(O.jsx)("h6",{style:{textAlign:"center"},children:" Are You sure you want to proceed?"})]})})}),Object(O.jsxs)("div",{className:"d-flex justify-content-between",children:[Object(O.jsx)("button",{type:"button",className:"btn btn-outline-danger m-2 btn-sm",onClick:()=>{t(!1)},children:"Cancel"}),Object(O.jsx)("button",{className:"btn btn-outline-success m-2 btn-sm",type:"submit",onClick:e=>{var n,s;n=e,s=A.id,n.preventDefault(),Object(i.e)(I.login.token,s).then((e=>{e.status?(d.NotificationManager.success(e.message,"Success",3e3),P(),t(!1)):d.NotificationManager.error(e.message,"Delete Failed!",3e3)})).catch((e=>{console.log(e),403==e.response.status?d.NotificationManager.error("You are not allowed to perform this task","Delete Failed!",3e3):d.NotificationManager.error("Unable to try Delete, check your connection","Delete Failed!",3e3)}))},children:"Continue"})]})]})})]})}}}]);
//# sourceMappingURL=11.218f7867.chunk.js.map