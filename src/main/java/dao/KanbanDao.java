package dao;

import business.KanbanBoard;

public class KanbanDao extends AbstractJpaDao<Long, KanbanBoard> {

    public KanbanDao() {
	super(KanbanBoard.class);
    }
    
}
