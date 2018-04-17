package web.manage.models;

import org.tmatesoft.svn.core.SVNDepth;
import org.tmatesoft.svn.core.SVNURL;
import org.tmatesoft.svn.core.wc.SVNClientManager;
import org.tmatesoft.svn.core.wc.SVNRevision;
import web.manage.entities.Branch;

import java.io.File;

public class AssetsStateModel {
    public static AssetsStateModel getModelByType(int type){
        return null;
    }

    /** -1 未知错误; 0 未初始化; 1 正在初始化; 2 正常; 3 忙碌; */
    public int state = 0;

    public Branch cfg;

    public SVNClientManager svnClientManager;

    public AssetsStateModel(Branch cfg){
        this.cfg = cfg;
    }

    public void init(){
        if(state > 0){
            return;
        }

        state = 1;
        File file = new File(cfg.getFolder());
        if(file.exists() && file.isDirectory()){

        }else{
            try {
                svnClientManager.getUpdateClient().doCheckout(SVNURL.parseURIEncoded(cfg.getDeSvn()),
                        new File(cfg.getFolder()), SVNRevision.HEAD,SVNRevision.HEAD, SVNDepth.INFINITY,true);
            }
            catch (Exception e){
                state = -1;
            }
            finally {
                state = 2;
            }
        }
    }

    public void build(){
        if(state != 2){
            return;
        }
    }
}
