(this["webpackJsonp@coreui/coreui-free-react-admin-template"]=this["webpackJsonp@coreui/coreui-free-react-admin-template"]||[]).push([[12],{591:function(e,t,n){"use strict";n.d(t,"i",(function(){return i})),n.d(t,"g",(function(){return a})),n.d(t,"h",(function(){return o})),n.d(t,"c",(function(){return l})),n.d(t,"n",(function(){return d})),n.d(t,"m",(function(){return u})),n.d(t,"e",(function(){return j})),n.d(t,"j",(function(){return h})),n.d(t,"d",(function(){return b})),n.d(t,"a",(function(){return m})),n.d(t,"b",(function(){return O})),n.d(t,"f",(function(){return x})),n.d(t,"l",(function(){return g})),n.d(t,"k",(function(){return p}));var s=n(565),c=n(576),r=n.n(c);const i=e=>{const t=Object(s.a)().um_url,n={headers:{Authorization:"Bearer ".concat(e)}};return r.a.get(t+"/UserRole/userRoleList",n).then((e=>e.data))},a=e=>{const t=Object(s.a)().um_url,n={headers:{Authorization:"Bearer ".concat(e)}};return r.a.get(t+"/UserAction/userActionList",n).then((e=>e.data))},o=(e,t)=>{const n=Object(s.a)().um_url,c={headers:{Authorization:"Bearer ".concat(e)}};return r.a.get(n+"/roleDefinition/definedRolesList?userRoleId="+t,c).then((e=>e.data))};function l(e,t){const n=Object(s.a)().um_url;return r()({method:"post",url:n+"/roleDefinition/defineRole",headers:{Authorization:"Bearer ".concat(e)},data:t}).then((e=>e.data))}function d(e,t){const n=Object(s.a)().um_url;return r()({method:"put",url:n+"/UserRole/updateUserRole",headers:{Authorization:"Bearer ".concat(e)},data:{id:t.id,name:t.name,description:t.description}}).then((e=>e.data))}function u(e,t){const n=Object(s.a)().um_url;return r()({method:"put",url:n+"/roleDefinition/updateDefinedActions",headers:{Authorization:"Bearer ".concat(e)},data:t}).then((e=>e.data))}function j(e,t){const n=Object(s.a)().um_url;return r()({method:"delete",url:n+"/roleDefinition/deleteUserRole?UserRoleID="+t,headers:{Authorization:"Bearer ".concat(e)}}).then((e=>e.data))}const h=e=>{const t=Object(s.a)().um_url,n={headers:{Authorization:"Bearer ".concat(e)}};return r.a.get(t+"/User/userList",n).then((e=>e.data))},b=(e,t)=>{const n=Object(s.a)().um_url;return r()({method:"post",url:n+"/User/createUser",headers:{Authorization:"Bearer ".concat(e)},data:t}).then((e=>e.data))},m=e=>{const t=Object(s.a)().um_url;return r.a.get(t+"/User/activationNumCheck?activationNO="+e).then((e=>e.data))},O=e=>{const t=Object(s.a)().um_url;return r()({method:"post",url:t+"/User/setUserNameAndPassword",data:e}).then((e=>e.data))};function x(e,t){const n=Object(s.a)().um_url;return r()({method:"delete",url:n+"/User/deleteUser?userId="+t,headers:{Authorization:"Bearer ".concat(e)}}).then((e=>e.data))}function g(e,t){const n=Object(s.a)().um_url;return r()({method:"put",url:n+"/User/suspendUser?userId="+t,headers:{Authorization:"Bearer ".concat(e)}}).then((e=>e.data))}function p(e,t){const n=Object(s.a)().um_url;return r()({method:"put",url:n+"/User/reactivateUser?userId="+t,headers:{Authorization:"Bearer ".concat(e)}}).then((e=>e.data))}},872:function(e,t,n){"use strict";n.r(t);var s=n(0),c=n.n(s),r=n(558),i=n(138),a=n(89),o=n(591),l=n(888),d=n(876),u=n(855),j=n(875),h=n(873),b=n(11);const m=e=>{switch(e){case 1:return"success";case"Inactive":return"secondary";case 2:return"warning";case 4:case 5:return"danger";default:return"primary"}},O=c.a.forwardRef((function(e,t){return Object(b.jsx)(h.a,{direction:"up",ref:t,...e})}));t.default=()=>{const[e,t]=Object(s.useState)(!1),[n,h]=Object(s.useState)(""),[x,g]=c.a.useState(!1),[p,f]=Object(s.useState)({}),[N,v]=Object(s.useState)([]),y=()=>{t(!e),I(""),C(""),D(""),q(""),P(""),Q(!0),H(!1)},k=Object(a.b)();Object(s.useEffect)((()=>{const e=[];e.push("firstName","lastName",{key:"email",_style:{width:"20%"}},"phone",{key:"userName",label:"userName",sorter:!1,filter:!1},"role","status",{key:"show_details",label:"Details",_style:{width:"1%"},sorter:!1,filter:!1}),k.login.roles.includes("VIEW_AND_MAINTAIN_USER_MANAGEMENT")&&e.push({key:"update",label:"Update",sorter:!1,filter:!1},{key:"delete",label:"Delete",sorter:!1,filter:!1}),v(e)}),[]);const A=(e,t)=>{g(!0),f(e),h(t)},U=e=>{Object(o.f)(k.login.token,e).then((e=>{e.status?(i.NotificationManager.success(e.message,"Success",3e3),X(),g(!1),ee([])):i.NotificationManager.error(e.message,"Failed!",3e3)})).catch((e=>{console.log(e),403==e.response.status?i.NotificationManager.error("You are not allowed to perform this task","Failed!",3e3):i.NotificationManager.error("Unable to try User Delete, check your connection","Failed!",3e3)}))},S=e=>{Object(o.l)(k.login.token,e).then((e=>{e.status?(i.NotificationManager.success(e.message,"Success",3e3),X(),g(!1),ee([])):i.NotificationManager.error(e.message,"Failed!",3e3)})).catch((e=>{console.log(e),403==e.response.status?i.NotificationManager.error("You are not allowed to perform this task","Failed!",3e3):i.NotificationManager.error("Unable to try User Suspend, check your connection","Failed!",3e3)}))},w=e=>{Object(o.k)(k.login.token,e).then((e=>{e.status?(i.NotificationManager.success(e.message,"Success",3e3),X(),g(!1),ee([])):i.NotificationManager.error(e.message,"Failed!",3e3)})).catch((e=>{console.log(e),403==e.response.status?i.NotificationManager.error("You are not allowed to perform this task","Failed!",3e3):i.NotificationManager.error("Unable to try User Suspend, check your connection","Failed!",3e3)}))},[_,R]=Object(s.useState)([]),[E,F]=Object(s.useState)([]),[M,I]=Object(s.useState)(""),[z,C]=Object(s.useState)(""),[B,D]=Object(s.useState)(""),[L,q]=Object(s.useState)(""),[T,P]=Object(s.useState)(""),[Y,G]=Object(s.useState)(""),[V,W]=Object(s.useState)(""),[J,H]=Object(s.useState)(!1),[K,Q]=Object(s.useState)(!0),X=()=>{Object(o.j)(k.login.token).then((e=>{R(e),console.log(e)})).catch((e=>console.log(e)))};Object(s.useEffect)((()=>{X()}),[]),Object(s.useEffect)((()=>{Object(o.i)(k.login.token).then((e=>{F(e),console.log(e)})).catch((e=>console.log(e)))}),[]);const[Z,$]=Object(s.useState)([]),ee=e=>{const t=Z.indexOf(e);let n=Z.slice();-1!==t?n.splice(t,1):n=[...Z,e],$(n)};return Object(b.jsxs)(b.Fragment,{children:[Object(b.jsxs)(r.J,{show:e,onClose:y,size:"lg",backdrop:!0,closeOnBackdrop:!1,children:[Object(b.jsx)(r.M,{size:"modal-lg",closeButton:!0,children:Object(b.jsx)("h4",{children:"Add User"})}),Object(b.jsxs)(r.O,{children:[Object(b.jsx)(r.i,{xs:"12",md:"12",children:Object(b.jsx)(r.e,{children:Object(b.jsx)(r.f,{children:Object(b.jsxs)("form",{onSubmit:e=>{e.preventDefault(),console.log("handle Submit here");const t=[];K&&t.push("email"),J&&t.push("sms");const n={userRoleId:T,firstName:M,lastName:z,email:B,phone:L,username:Y,password:V};console.log(n),Object(o.d)(k.login.token,n).then((e=>{e.status?(i.NotificationManager.success(e.message,"Success",3e3),X(),y()):i.NotificationManager.error(e.message,"Failed!",3e3)})).catch((e=>{console.log(e),403==e.response.status?i.NotificationManager.error("You are not allowed to perform this task","Failed!",3e3):i.NotificationManager.error("Unable to try User Create, check your connection","Failed!",3e3)}))},children:[Object(b.jsxs)(r.t,{row:!0,children:[Object(b.jsx)(r.i,{md:"2",children:Object(b.jsx)(r.F,{htmlFor:"text-input",children:"First Name"})}),Object(b.jsx)(r.i,{xs:"12",md:"4",children:Object(b.jsx)(r.y,{id:"text-input",name:"text-input",onInput:e=>I(e.target.value),value:M,placeholder:"Enter First Name",required:!0})}),Object(b.jsx)(r.i,{md:"2",children:Object(b.jsx)(r.F,{htmlFor:"text-input",children:"Last Name"})}),Object(b.jsx)(r.i,{xs:"12",md:"4",children:Object(b.jsx)(r.y,{id:"text-input",name:"text-input",onInput:e=>C(e.target.value),value:z,placeholder:"Enter Last Name",required:!0})})]}),Object(b.jsxs)(r.t,{row:!0,children:[Object(b.jsx)(r.i,{md:"2",children:Object(b.jsx)(r.F,{htmlFor:"email-input",children:"Phone Number"})}),Object(b.jsx)(r.i,{xs:"12",md:"4",children:Object(b.jsx)(r.y,{id:"email-input",name:"email-input",onInput:e=>q(e.target.value),value:L,placeholder:"Enter Phone Number",required:!0})}),Object(b.jsx)(r.i,{md:"2",children:Object(b.jsx)(r.F,{htmlFor:"email-input",children:"Email"})}),Object(b.jsx)(r.i,{xs:"12",md:"4",children:Object(b.jsx)(r.y,{type:"email",id:"email-input",name:"email-input",onInput:e=>D(e.target.value),value:B,placeholder:"Enter Email",autoComplete:"email",required:!0})})]}),Object(b.jsxs)(r.t,{row:!0,children:[Object(b.jsx)(r.i,{md:"2",children:Object(b.jsx)(r.F,{htmlFor:"email-input",children:"Username"})}),Object(b.jsx)(r.i,{xs:"12",md:"4",children:Object(b.jsx)(r.y,{id:"username-input",name:"username-input",onInput:e=>G(e.target.value),value:Y,placeholder:"Enter Username",required:!0})}),Object(b.jsx)(r.i,{md:"2",children:Object(b.jsx)(r.F,{htmlFor:"email-input",children:"Password"})}),Object(b.jsx)(r.i,{xs:"12",md:"4",children:Object(b.jsx)(r.y,{id:"password-input",name:"password-input",onInput:e=>W(e.target.value),value:V,placeholder:"Enter Password",required:!0})})]}),Object(b.jsx)(r.t,{row:!0}),Object(b.jsxs)(r.t,{row:!0,children:[Object(b.jsx)(r.i,{md:"2",children:Object(b.jsx)(r.F,{htmlFor:"selectLg",children:"Select Role"})}),Object(b.jsx)(r.i,{xs:"12",md:"4",size:"lg",children:Object(b.jsxs)(r.P,{custom:!0,name:"selectLg",id:"selectLg",value:T,onChange:e=>{P(e.target.value)},children:[Object(b.jsx)("option",{value:0,children:"--Select User Role--"},-1),E.map(((e,t)=>Object(b.jsx)("option",{value:e.id,children:e.name},t)),void 0)]})}),Object(b.jsx)(r.i,{tag:"label",sm:"2",md:"2",className:"col-form-label",children:"Notification"}),Object(b.jsxs)(r.i,{sm:"4",children:[Object(b.jsxs)(r.t,{variant:"custom-checkbox",inline:!0,children:[Object(b.jsx)(r.z,{custom:!0,id:"inline-checkbox1",name:"inline-checkbox1",value:"sms",disabled:!0,checked:J,onClick:e=>{H(e.target.checked),console.log("Sms selected"+e.target.checked)}}),Object(b.jsx)(r.F,{variant:"custom-checkbox",htmlFor:"inline-checkbox1",children:"SMS"}),Object(b.jsx)(r.t,{variant:"custom-checkbox",inline:!0})]}),Object(b.jsxs)(r.t,{variant:"custom-checkbox",inline:!0,children:[Object(b.jsx)(r.z,{custom:!0,id:"inline-checkbox2",name:"inline-checkbox2",value:"email",checked:K,onClick:e=>{Q(e.target.checked),console.log("Email selected"+e.target.checked)}}),Object(b.jsx)(r.F,{variant:"custom-checkbox",htmlFor:"inline-checkbox2",children:"Email"})]})]})]}),Object(b.jsx)(r.g,{}),Object(b.jsxs)("div",{className:"d-flex justify-content-between",children:[Object(b.jsx)("button",{type:"button",className:"btn btn-outline-danger m-2 btn-md",onClick:y,children:"Cancel"}),Object(b.jsx)("button",{type:"submit",className:"btn btn-outline-success m-2 btn-md",children:"Submit"})]})]})})})}),Object(b.jsx)(r.i,{xs:"12",md:"6"})]})]}),Object(b.jsx)(r.O,{children:Object(b.jsx)(r.i,{children:Object(b.jsxs)(r.e,{children:[Object(b.jsx)(r.h,{children:Object(b.jsxs)("div",{className:"d-flex justify-content-between",children:[Object(b.jsx)("h4",{children:"Users"}),Object(b.jsx)("div",{className:"d-flex justify-content-end",children:k.login.roles.includes("CREATE_USER")?Object(b.jsx)("button",{type:"button",className:"btn btn-outline-success m-2 btn-md",onClick:y,children:"Add User"}):""})]})}),Object(b.jsx)(r.f,{children:Object(b.jsx)(r.m,{items:_,fields:N,tableFilter:!0,itemsPerPageSelect:!0,itemsPerPage:5,hover:!0,size:"sm",striped:!0,bordered:!0,outlined:!0,pagination:!0,scopedSlots:{status:e=>Object(b.jsx)("td",{children:Object(b.jsx)(r.a,{color:m(e.statusId),children:e.statusName})}),role:e=>Object(b.jsx)("td",{children:e.userRoleName}),userName:e=>Object(b.jsx)("td",{children:null==e.userName?Object(b.jsx)("strong",{children:"Not Set"}):e.userName}),show_details:(e,t)=>Object(b.jsx)("td",{className:"py-2",children:Object(b.jsx)(r.d,{color:"primary",variant:"outline",shape:"square",size:"sm",onClick:()=>{ee(t)},children:Z.includes(t)?"Hide":"Show"})}),update:(e,t)=>Object(b.jsx)("div",{children:k.login.roles.includes("VIEW_AND_MAINTAIN_USER_MANAGEMENT")?Object(b.jsx)("td",{className:"py-2",children:Object(b.jsx)(r.d,{color:"warning",variant:"outline",shape:"square",size:"sm",onClick:()=>{},children:"Update"})}):""}),delete:(e,t)=>Object(b.jsx)("td",{className:"py-2",children:k.login.roles.includes("VIEW_AND_MAINTAIN_USER_MANAGEMENT")?Object(b.jsx)(r.d,{color:"danger",variant:"outline",shape:"square",size:"sm",onClick:()=>A(e,"Delete"),children:"Delete"}):""}),details:(e,t)=>Object(b.jsx)(r.j,{show:Z.includes(t),children:Object(b.jsx)(r.f,{children:Object(b.jsxs)("div",{className:"d-flex justify-content-start",children:[Object(b.jsxs)("div",{style:{marginRight:20,width:"40%"},children:[Object(b.jsx)("h4",{style:{marginBottom:4},children:Object(b.jsx)("strong",{children:e.firstName+" "+e.lastName})}),Object(b.jsx)("p",{children:Object(b.jsxs)("p",{className:"text-muted",children:["Registered On: ",new Date(parseFloat(e.createdOn)).toLocaleString()]})})]}),2==e.statusId?Object(b.jsxs)("div",{style:{marginRight:20,width:"60%"},children:[Object(b.jsx)("h6",{style:{marginBottom:4},children:Object(b.jsx)("strong",{children:"User Activation"})}),Object(b.jsxs)("p",{children:["User has not been activated yet.",Object(b.jsx)(r.d,{variant:"outline",color:"warning",shape:"square",size:"sm",style:{marginLeft:10,marginRight:10},children:"Resend Activation number"})]}),Object(b.jsxs)("div",{style:{marginRight:20,width:"60%"},children:[Object(b.jsx)("h6",{style:{marginBottom:4},children:Object(b.jsx)("strong",{children:"Activation Number"})}),Object(b.jsx)("p",{children:e.activationNo})]})]}):1==e.statusId?Object(b.jsxs)("div",{style:{marginRight:20,width:"60%"},children:[Object(b.jsx)("h6",{style:{marginBottom:4},children:Object(b.jsx)("strong",{children:"User Activation"})}),Object(b.jsxs)("p",{children:["User account Activated.",k.login.roles.includes("VIEW_AND_MAINTAIN_USER_MANAGEMENT")?Object(b.jsx)(r.d,{variant:"outline",color:"danger",shape:"square",size:"sm",style:{marginLeft:10,marginRight:10,paddingLeft:10,paddingRight:10},onClick:()=>A(e,"Suspend"),children:" Suspend User"}):""]})]}):4==e.statusId?Object(b.jsxs)("div",{style:{marginRight:20,width:"60%"},children:[Object(b.jsx)("h6",{style:{marginBottom:4},children:Object(b.jsx)("strong",{children:"User Activation"})}),Object(b.jsxs)("p",{children:["User account Suspended.",k.login.roles.includes("VIEW_AND_MAINTAIN_USER_MANAGEMENT")?Object(b.jsx)(r.d,{variant:"outline",color:"success",shape:"square",size:"sm",style:{marginLeft:10,marginRight:10},onClick:()=>A(e,"Reactivate"),children:" Reactivate User"}):""]})]}):""]})})})}})})]})})}),Object(b.jsx)("div",{children:Object(b.jsxs)(l.a,{open:x,TransitionComponent:O,keepMounted:!0,"aria-labelledby":"alert-dialog-slide-title","aria-describedby":"alert-dialog-slide-description",children:[Object(b.jsx)(j.a,{id:"alert-dialog-slide-title",children:Object(b.jsx)("h5",{children:"Are You sure?"})}),Object(b.jsx)(d.a,{children:Object(b.jsx)(u.a,{id:"alert-dialog-slide-description",children:Object(b.jsxs)("div",{children:[Object(b.jsx)("h5",{style:{textAlign:"center"},children:Object(b.jsxs)("small",{children:["You are about to ",n," User ",Object(b.jsx)("strong",{children:p.firstName+" "+p.lastName+" "})," - Role ",Object(b.jsx)("strong",{children:p.userRoleName})]})}),Object(b.jsx)("h6",{style:{textAlign:"center"},children:" Are You sure you want to proceed?"})]})})}),Object(b.jsxs)("div",{className:"d-flex justify-content-between",children:[Object(b.jsx)("button",{type:"button",className:"btn btn-outline-danger m-2 btn-sm",onClick:()=>{g(!1)},children:"Cancel"}),Object(b.jsx)("button",{className:"btn btn-outline-success m-2 btn-sm",type:"submit",onClick:e=>{var t;t=p.userId,n.length>0&&("Delete"==n?U(t):"Suspend"==n?S(t):"Reactivate"==n&&w(t))},children:"Continue"})]})]})})]})}}}]);
//# sourceMappingURL=12.98469de9.chunk.js.map