const { ipcRenderer } = window.require('electron')

export async function $insertDB(table,data){
  var keyArr=Object.keys(data);
  var valArr=Object.values(data)
  var keyStr=keyArr.join(',');
  for(var i=0;i<valArr.length;i++){
    valArr[i]="'"+valArr[i]+"'";
  }
  var dataStr=valArr.join(',');
  var sql="insert into "+table+"("+keyStr+") values ("+dataStr+")";
  console.log(sql);
  var res=await $runSql(sql)
  console.log('执行insert',sql,res)
  return res>0;
}

export async function $runSql(sql){
  return ipcRenderer.invoke('sqlite-run',sql)
}

export async function $updateDBfromID(table,data,id){
  var dataStr="";
  var keyArr=Object.keys(data);
  var valArr=Object.values(data)
  for(var i=0;i<valArr.length;i++){
    valArr[i]="'"+valArr[i]+"'";
  }
  var listArr=[];
  for(i=0;i<valArr.length;i++){
    listArr.push(keyArr[i]+"="+valArr[i]);
  }
  dataStr=listArr.join(',');
  var sql="update "+table+" set "+dataStr+" where id="+id;
  return await $runSql(sql)
}

export async function $queryDB(sql){
  return ipcRenderer.invoke('sqlite-query',sql)
}

