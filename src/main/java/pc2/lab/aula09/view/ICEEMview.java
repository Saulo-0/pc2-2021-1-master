package pc2.lab.aula09.view;

import pc2.lab.aula09.dao.DAO;

public interface ICEEMview <T> extends IBasicView {
    public void askSubMenu(DAO dao, int hash);
    public T criar();
    public void editar(DAO dao, int hash);
    public void excluir(DAO dao, int hash);
    public void mostrar(DAO dao, int hash);
}
